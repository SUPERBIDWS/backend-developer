package net.superbid.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PostDTO implements Serializable {

	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataPublicacao;
	private String titulo;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	@NotNull(message = "Título é uma informação obrigatória")
	@Length(min = 3, max = 40, message = "Título deve estar entre 3 e 40 caracteres")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@NotNull(message = "Descrição é uma informação obrigatória")
	@Length(min = 10, max = 1500, message = "Descrição deve estar entre 10 e 1500 caracteres")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
