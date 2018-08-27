package com.leo.blog.ws.post;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.leo.blog.commons.exception.BindingException;
import com.leo.blog.commons.exception.BindingExceptionDetails;

@ControllerAdvice
@RestController
public class ExceptionControllerAdvice {

  @ExceptionHandler(BindingException.class)
  public BindingExceptionDetails bindingException(BindingException ex) {
    return new BindingExceptionDetails(ex.getResults());
  }
  
}
