package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programId;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    //Change to eager fetch may be required as we usually would fetch the program with the intention of getting the classes under it.
    //@OneToMany(mappedBy = "program",fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Class> classes;

    @ManyToMany(mappedBy = "programs")
    private List<Instructor> instructors;
}