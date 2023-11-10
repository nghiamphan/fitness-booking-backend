package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "qualification")
@Data
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "_id")
    private Instructor instructor;

    @OneToOne
    @JoinColumn(name = "program_id", referencedColumnName = "_id")
    private Program program;
}