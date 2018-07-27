package net.superbid.blog.controller.exception;

import net.superbid.blog.dto.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom runtime exception to handle invalid DTO data.
 *
 * @author renato
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPostDataException extends RuntimeException {

    private static final long serialVersionUID = -2895873169442110680L;
    
    private final String field;

    /**
     * Constructor for invalid post ID.
     * @param postId post unique identifier
     */
    public InvalidPostDataException(Long postId) {
        super("Invalid post ID=" + postId + ".");
        field = "id";
    }

    /**
     * Constructor for generic post field invalid data.
     * @param post
     * @param field 
     */
    public InvalidPostDataException(PostDTO post, String field) {
        super("Invalid post data: " + post + ".");
        this.field = field;
    }

    /**
     * Get invalid field name.
     * @return field name, such as 'id', 'title' and 'description'
     */
    public String getField() {
        return field;
    }
}
