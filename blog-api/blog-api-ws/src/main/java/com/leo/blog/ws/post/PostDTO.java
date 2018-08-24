package com.leo.blog.ws.post;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.leo.blog.core.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	
	private Integer id;
	@NotNull
	private LocalDateTime dataPublicacao;
	@NotBlank
	private String titulo;
	@NotBlank
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
