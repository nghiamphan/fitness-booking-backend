package smu.mcda5540.fitnessbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "register")
@Data
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "_id")
    private Person person;

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "_id")
    private Class mClass;
}