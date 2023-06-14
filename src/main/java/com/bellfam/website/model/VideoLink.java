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
@Table(name = "video_link")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VideoLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "link")
    private String linkValue;

    @Column(name = "description")
    private String description;
}
