package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "class")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "available_space")
    private int availableSpace;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "_id")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "_id")
    private Location location;
}