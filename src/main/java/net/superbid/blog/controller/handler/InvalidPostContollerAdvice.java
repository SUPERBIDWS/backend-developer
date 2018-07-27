package net.superbid.blog.controller.handler;

import net.superbid.blog.controller.handler.dto.ValidationErrorDTO;
import java.util.List;
import net.superbid.blog.controller.exception.InvalidPostDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler class for MethodArgumentNotValidException and InvalidPostDataException
 * exceptions. It handles such exceptions returning only a status code and its 
 * invalid field message, replacing Spring's default exception handler.
 *
 * @author renato
 */
@ControllerAdvice
public class InvalidPostContollerAdvice extends ResponseEntityExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException, returning just a 400 response code.
     * along with a list of invalid fields and their messages.
     * @param ex exception
     * @param headers request  headers
     * @param status response status
     * @param request request wrapper
     * @return configured response entity, containing 400 status code and list of invalid field errors.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return new ResponseEntity(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles custom InvalidPostDataException, returning just a 400 response code.
     * along with a invalid field and its messages.
     * @param ex exception
     * @param request request wrapper
     * @return configured response entity, containing 400 status code and invalid field error.
     */
    @ExceptionHandler(InvalidPostDataException.class)
    public final ResponseEntity<ValidationErrorDTO> handleInvalidPostException(InvalidPostDataException ex, WebRequest request) {
        
        ValidationErrorDTO dto = new ValidationErrorDTO();
        dto.addFieldError(ex.getField(), ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Helper method to encapsulate list of field errors into a single DTO.
     * @param fieldErrors list of field errors
     * @return single DTO containing all field errors
     */
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
        fieldErrors.forEach((fieldError) -> {
            dto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return dto;
    }
}