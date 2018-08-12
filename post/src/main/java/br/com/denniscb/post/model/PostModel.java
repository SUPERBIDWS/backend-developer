package br.com.denniscb.post.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "POST")
public class PostModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
	@SequenceGenerator(name = "post_sequence", sequenceName = "post_seq")
	@Column(name = "id_post")
	private Long id;
	
	@NotBlank(message = "O post não pode estar em branco")
	@Column(name = "post")
	private String post;
	
	@Column(name = "data_cricao")
	private Date dataCricacao;
	
	@NotBlank(message = "O titulo não pode estar em branco")
	@Column(name = "titulo")
	private String titulo;
	
	@NotBlank(message = "A descricao não pode estar em branco")
	@Column(name = "descricao")
	private String descricao;

	@PrePersist
	public void setDataCriacaoPost() {
		dataCricacao = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getDataCricacao() {
		return dataCricacao;
	}

	public void setDataCricacao(Date dataCricacao) {
		this.dataCricacao = dataCricacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	

}
