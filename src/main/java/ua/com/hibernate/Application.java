package ua.com.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
public class Application {
    public static void main(String[] args) {
       new AnnotationConfigApplicationContext(Application.class);
    }
}
