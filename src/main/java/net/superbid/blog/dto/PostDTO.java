package net.superbid.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * Data transfer object for Post, to avoid directly exposing internal (DB) schema.
 *
 * @author renato
 */
@Data
@Builder
public class PostDTO {
    
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 128, message="Title should have between 3 and 128 characters!")
    private String title;
    
    @Size(max = 512, message="Description should have at most 512 characters!")
    private String description;
    
    // Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;
}
