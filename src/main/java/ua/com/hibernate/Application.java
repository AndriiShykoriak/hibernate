package ua.com.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ua.com.hibernate.view.impl.MenuImpl;
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MenuImpl menu = context.getBean(MenuImpl.class);
        menu.start();
    }
}
