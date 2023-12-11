package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    @Column(nullable = true)
    private int roomSize;

    @OneToMany(mappedBy = "location")
    private List<Class> classes;
}