package com.leo.blog.ws.post;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.leo.blog.core.entity.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Post", description="Classe que representa um post")
public class PostDTO {
	
	@ApiModelProperty(value="Código do post")
	private Integer id;
	
	@NotNull
	@ApiModelProperty(value="data de publicação do post", example="2018-01-08T20:21:03")
	private LocalDateTime dataPublicacao;
	
	@NotBlank
	@ApiModelProperty(value="Título do post")
	private String titulo;
	
	@NotBlank
	@ApiModelProperty(value="Descrição do post")
	private String descricao;
	
	public Post build() {
		return Post.builder()
				.dataPublicacao(dataPublicacao)
				.titulo(titulo)
				.descricao(descricao)
				.build();
	}
	
	public static PostDTO from(Post post) {
		return PostDTO.builder()
					  .id(post.getId())
					  .titulo(post.getTitulo())
					  .dataPublicacao(post.getDataPublicacao())
					  .descricao(post.getDescricao())
					  .build();
	}
	
}
