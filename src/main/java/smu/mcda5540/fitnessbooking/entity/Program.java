package smu.mcda5540.fitnessbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programId;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    //Change to eager fetch may be required as we usually would fetch the program with the intention of getting the classes under it.
    //@OneToMany(mappedBy = "program",fetch = FetchType.EAGER)
    @JsonIgnore
    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Class> classes;

    @JsonIgnore
    @ManyToMany(mappedBy = "programs")
    private List<Instructor> instructors;
}