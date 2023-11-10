package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "instructor")
@Data
public class Instructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "_id")
    private Person person;

    @Column(name = "bio")
    private String bio;

    @Column(name = "business_phone")
    private String businessPhone;
}