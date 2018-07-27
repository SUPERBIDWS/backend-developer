package net.superbid.blog.controller.handler.dto;

/**
 * DTO class for field validation errors.
 *
 * @author renato
 */
public class FieldErrorDTO {
 
    private final String field;
 
    private final String message;
 
    /**
     * Constructor.
     * @param field field name
     * @param message message indicating field validation error
     */
    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * Get field name.
     * @return field name
     */
    public String getField() {
        return field;
    }

    /**
     * Get field validation error message.
     * @return error message
     */
    public String getMessage() {
        return message;
    }
}
