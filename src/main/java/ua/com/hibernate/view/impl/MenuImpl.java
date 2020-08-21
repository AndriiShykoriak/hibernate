package ua.com.hibernate.view.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.com.hibernate.model.User;
import ua.com.hibernate.service.impl.UserServiceImpl;

import java.util.Scanner;
@Component
public class MenuImpl {
    @Autowired
    UserServiceImpl userService;

    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("" +
                "1.Add User" +
                "2.Update User" +
                "3.Delete User" +
                "4.FindById User" +
                "5.FindByAll Users" +
                "6.Add Book to User" +
                "7.Find All Books User" +
                "8.Exit");
        loop:
        switch (scanner.nextInt()) {
            case 1 -> User();
            case 8 -> {
                break loop;
            }
        }

    }

    private void User() {
        User user = new User();
        System.out.print("Input name: ");
        user.setName(scanner.next());
        System.out.print("Input surname: ");
        user.setSurname(scanner.next());
        userService.addUser(user);
        System.out.println("user saved");
    }
}
