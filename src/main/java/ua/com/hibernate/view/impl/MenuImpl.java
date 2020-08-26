package ua.com.hibernate.view.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.hibernate.model.Book;
import ua.com.hibernate.model.User;
import ua.com.hibernate.service.BookService;
import ua.com.hibernate.service.UserService;
import ua.com.hibernate.view.Menu;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

@Component
public class MenuImpl implements Menu {
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
                "5.FindByAll Users and show theirs books\n" +
                "6.Add Book to User\n" +
                "7.Find All Books \n" +
                "8.Exit");
        loop:
        switch (scanner.nextInt()) {
            case 1 -> addUserMenu();
            case 2 -> updateUserMenu();
            case 3 -> deleteUserMenu();
            case 4 -> findByIdUserMenu();
            case 5 -> findByAllUsersMenu();
            case 6 -> addBookToUserMenu();
            case 7 -> findByALLBookMenu();
            case 8 -> {
                break loop;
            }
            default -> {
                System.out.println("Input correct number");
                start();
            }
        }

    }

    @Override
    public void addUserMenu() {
        var user = new User();
        System.out.print("Input name: ");
        user.setName(scanner.next());
        System.out.print("Input surname: ");
        user.setSurname(scanner.next());
        userService.addUser(user);
        System.out.println("user saved");
        start();
    }

    @Override
    public void updateUserMenu() {
        System.out.println("Input id: ");
        var user = userService.findById(scanner.nextInt());
        System.out.print("Input name: ");
        user.setName(scanner.next());
        System.out.print("Input surname: ");
        user.setSurname(scanner.next());
        userService.updateUser(user);
        System.out.println("user updated");
        start();
    }

    @Override
    public void deleteUserMenu() {
        System.out.println("Input id: ");
        var user = userService.findById(scanner.nextInt());
        userService.deleteUser(user);
        System.out.println("user deleted");
        start();
    }

    @Override
    public void findByIdUserMenu() {
        System.out.println("Input id: ");
        var user = userService.findById(scanner.nextInt());
        System.out.println(user);
        start();
    }

    @Override
    public void findByAllUsersMenu() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        start();
    }

    @Override
    public void addBookToUserMenu() {
        System.out.println("Input user id: ");
        var user = userService.findById(scanner.nextInt());
        if (user != null) {
            var book = new Book();
            System.out.println("Input title: ");
            book.setName(scanner.next());
            user.getBooks().add(book);
            userService.updateUser(user);
            System.out.println("book saved to user");
            start();
        }
    }

    @Override
    public void findByALLBookMenu() {
        List<Book> books = bookService.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
        start();
    }
}
