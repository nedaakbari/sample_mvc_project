package org.example.sample.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    private Users users;
    @Column(unique = true, nullable = false)
    private String nationalCode;
    private String employeeID;
    private Timestamp birthdate;
    @Email
    private String email;
//    @ManyToMany
//    private Role role;
//    @ManyToOne
//    private Employee manager;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp insertTime;
}
