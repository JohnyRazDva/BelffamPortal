package com.bellfam.website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Eugene Petrov
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserRole {
    private int id;
    private int userId;
    private int roleId;
}
