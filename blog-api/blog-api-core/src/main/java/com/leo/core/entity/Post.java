package com.leo.core.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	private Integer id;
	private LocalDateTime dataPublicacao;
	private String titulo;
	private String descricao;
	
	public Integer getId() {
		return id;
	}

}
