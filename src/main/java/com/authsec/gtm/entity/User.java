package com.authsec.gtm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "password", nullable = false , length = 200)
    private String password;

    @Column(name = "email_address", nullable = false , unique = true)
    private String email;

//    public User()
//    {
//
//    }
//
//    public User(String firstname, String lastname, String password, String email) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.password = password;
//        this.email = email;
//    }
}
