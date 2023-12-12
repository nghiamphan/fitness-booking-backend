package smu.mcda5540.fitnessbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "instructor_id")
public class Instructor extends Person implements Serializable {
    @Column(nullable = false)
    private String bio;

    @Column(unique = true)
    private String businessPhone;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<Class> classes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "qualification", joinColumns = @JoinColumn(name = "instructor_id"), inverseJoinColumns = @JoinColumn(name = "program_id"))
    private List<Program> programs;
}