package ua.com.hibernate.view.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.hibernate.model.Book;
import ua.com.hibernate.model.User;
import ua.com.hibernate.service.BookService;
import ua.com.hibernate.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

@Component
public class MenuImpl {
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    Scanner scanner = new Scanner(System.in);

    @PostConstruct
    public void start() {
        System.out.println("\n" +
                "1.Add User\n" +
                "2.Update User\n" +
                "3.Delete User\n" +
                "4.FindById User\n" +
                "5.FindByAll Users\n" +
                "6.Add Book to User\n" +
                "7.Find All Books User\n" +
                "8.Exit");
        loop:
        switch (scanner.nextInt()) {
            case 1 -> addUserMenu();
            case 2 -> updateUserMenu();
            case 3 -> deleteUserMenu();
            case 4 -> findByIdUserMenu();
            case 5 -> findByAllUserMenu();
            case 6 -> addBookToUser();
            case 8 -> {
                break loop;
            }
        }

    }

    private void addUserMenu() {
        User user = new User();
        System.out.print("Input name: ");
        user.setName(scanner.next());
        System.out.print("Input surname: ");
        user.setSurname(scanner.next());
        userService.addUser(user);
        System.out.println("user saved");
        start();
    }

    private void updateUserMenu() {
        System.out.println("Input id: ");
        User user = userService.findById(scanner.nextInt());
        System.out.print("Input name: ");
        user.setName(scanner.next());
        System.out.print("Input surname: ");
        user.setSurname(scanner.next());
        userService.updateUser(user);
        System.out.println("user updated");
        start();
    }

    private void deleteUserMenu() {
        System.out.println("Input id: ");
        User user = userService.findById(scanner.nextInt());
        userService.deleteUser(user);
        System.out.println("user deleted");
    }

    private void findByIdUserMenu() {
        System.out.println("Input id: ");
        User user = userService.findById(scanner.nextInt());
        System.out.println(user);
    }

    private void findByAllUserMenu() {
        List<User> user = userService.findAll();
        for (User users : user) {
            System.out.println(users);
        }
    }

    private void addBookToUser() {
        Book book = new Book();
        System.out.println("Input title: ");
        book.setName(scanner.next());
        bookService.addBook(book);
    }
}
