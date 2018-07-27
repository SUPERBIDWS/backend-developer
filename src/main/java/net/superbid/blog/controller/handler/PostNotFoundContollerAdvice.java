package net.superbid.blog.controller.handler;

import net.superbid.blog.controller.exception.PostNotFoundException;
import net.superbid.blog.controller.handler.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler class for PostNotFound exception. It handles such exception
 * returning only a status code and its exception message, replacing Spring's
 * default exception handler which exposes internal structure.
 *
 * @author renato
 */
@ControllerAdvice
public class PostNotFoundContollerAdvice extends ResponseEntityExceptionHandler {

    /**
     * Handles PostNotFoundException, returning just exception's message and 404 response status.
     * @param ex exception
     * @param request request wrapper
     * @return configured response entity
     */
    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ErrorDTO> handlePostNotFoundException(PostNotFoundException ex, WebRequest request) {
        ErrorDTO errorDetails = new ErrorDTO(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
