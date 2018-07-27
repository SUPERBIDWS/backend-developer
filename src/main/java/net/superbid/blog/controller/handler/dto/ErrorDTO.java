package net.superbid.blog.controller.handler.dto;

import java.util.Date;

/**
 * Generic DTO class for error information.
 *
 * @author renato
 */
public class ErrorDTO {

    private final Date timestamp = new Date();
    private final String message;
    private final String details;

    public ErrorDTO(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
