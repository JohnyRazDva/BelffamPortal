package com.bellfam.website.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @Size(min = 2, max = 20, message = "Firstname should be from 2 to 20 chars")
    private String firstName;

    @Column(name = "lastName")
    @Size(min = 2, max = 20, message = "Lastname should be from 2 to 20 chars")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    @Size(min = 2, max = 20, message = "Username should be from 2 to 20 chars")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private List<String> authorities;
}
