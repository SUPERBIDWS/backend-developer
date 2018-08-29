package com.ibeans.blog.dta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by igotavares on 07/08/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publicationDate;

    public PostDTO(Long id) {
        this(id, null, null, null);
    }

    public PostDTO(String title, String description, LocalDateTime publicationDate) {
        this(null, title, description, publicationDate);
    }
}
