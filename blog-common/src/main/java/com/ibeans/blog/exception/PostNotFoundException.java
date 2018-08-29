package com.ibeans.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by igotavares on 07/08/2018.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Post")
public class PostNotFoundException extends BlogException {
}
