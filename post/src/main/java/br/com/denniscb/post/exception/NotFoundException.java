package br.com.denniscb.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Post")  // 404
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7182103246480973666L;
    
	
}
