package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "instructor_id")
public class Instructor extends Person implements Serializable {
    @Column(nullable = false)
    private String bio;

    @Column(unique = true)
    private String businessPhone;

    @OneToMany(mappedBy = "instructor")
    private List<Class> classes;

    @ManyToMany
    @JoinTable(name = "qualification", joinColumns = @JoinColumn(name = "instructor_id"), inverseJoinColumns = @JoinColumn(name = "program_id"))
    private List<Program> programs;
}