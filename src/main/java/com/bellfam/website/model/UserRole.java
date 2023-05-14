package com.bellfam.website.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Eugene Petrov
 */
@Entity
@Table(name = "user_role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "roleId")
    private int roleId;
}
