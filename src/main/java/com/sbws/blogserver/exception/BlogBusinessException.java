package com.sbws.blogserver.exception;

public class BlogBusinessException extends RuntimeException {

	private static final long serialVersionUID = -7026972515905409151L;

	public BlogBusinessException(String mensagem) {
		super(mensagem);
	}

}
