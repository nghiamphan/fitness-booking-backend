package smu.mcda5540.fitnessbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Class> classes;
}