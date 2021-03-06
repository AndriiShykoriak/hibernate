package ua.com.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String name;
    @Column(name = "secondName")
    private String surname;
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books;
}
