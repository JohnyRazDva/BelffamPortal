package com.bellfam.website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Eugene Petrov
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Post {
    private int id;
    private String text;
    private int userId;
    private Date date;
}
