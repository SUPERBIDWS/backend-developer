package com.sbws.blogserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SeqBlog", sequenceName = "SeqBlog", initialValue = 1, allocationSize = 10)
public class Blog implements Serializable {
	
	private static final long serialVersionUID = -2066484922781496532L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
	
	private Date dataPublicacao;
	
	@Size(max=70)
	private String titulo;
	
	private String descricao;

}
