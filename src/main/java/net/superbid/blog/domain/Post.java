package net.superbid.blog.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain class for post entity. A blog post contains an unique identifier,
 * a title, a description field for its content, and a published date.
 *
 * @author renato
 */
@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "sbws_post")
public class Post implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 128)
    private String title;
    
    @NotNull
    @Size(max = 512)
    private String description;
    
    @Builder.Default
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date publishedDate = new Date();
}
