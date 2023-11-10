package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "program")
@Data
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}