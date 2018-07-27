package net.superbid.blog.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author renato
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -733258329114116877L;

    public PostNotFoundException(Long postId) {
        super("Could not find post with ID=" + postId + ".");
    }
}
