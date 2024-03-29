package com.bellfam.website.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * @author Eugene Petrov
 */
@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "author")
    private String author;

    @CreatedDate
    @Column(name = "date")
    private Date date;
}
