package com.ibeans.blog.domain.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by igotavares on 07/08/2018.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime publicationDate;

    public Post(String title, String description, LocalDateTime publicationDate) {
        this(null, title, description, publicationDate);
    }

}
