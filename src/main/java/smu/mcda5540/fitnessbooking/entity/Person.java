package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "booking", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<Class> classes;
}