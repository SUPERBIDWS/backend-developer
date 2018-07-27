package net.superbid.blog.controller.handler.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for multiple field validation errors.
 *
 * @author renato
 */
public class ValidationErrorDTO {

    private final List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    /**
     * Add new field error to be sent as response.
     * @param field field name
     * @param message field validation error message
     */
    public void addFieldError(String field, String message) {
        FieldErrorDTO error = new FieldErrorDTO(field, message);
        fieldErrors.add(error);
    }

    /**
     * Get the list of all field errors.
     * @return list of field errors
     */
    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    
}
