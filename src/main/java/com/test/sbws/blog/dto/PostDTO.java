package com.test.sbws.blog.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	private Long id;
	
	private LocalDateTime publishDatetime;
	
	@NotNull
	private String title;

	@NotNull
	private String description;

}
