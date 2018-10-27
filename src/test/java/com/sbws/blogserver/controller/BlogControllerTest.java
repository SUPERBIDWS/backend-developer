package com.sbws.blogserver.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sbws.blogserver.model.Blog;
import com.sbws.blogserver.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BlogControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(BlogControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlogService service;
	
	public static final String DESCRICAO_01_POST = "Descricao do post teste";
	public static final String TITULO_01_POST = "Titulo do post teste";
	
	public static final String DESCRICAO_02_POST = "Descricao do post teste 2";
	public static final String TITULO_02_POST = "Titulo do post teste 2";
	
	public static final String DESCRICAO_03_POST = "Descricao do post teste 3";
	public static final String TITULO_03_POST = "Titulo do post teste 3";	
	
	private Blog blog01 = null;
	private Blog blog01WithId = null;
	private Blog blog02 = null;
	private Blog blog03 = null;
	List<Blog> listagemTodosBlogPosts = null;
	
	@Before
	public void beforeTests() {
		blog01 = criaPostBlog(DESCRICAO_01_POST, TITULO_01_POST);
		blog01WithId = criaPostBlog(DESCRICAO_01_POST, TITULO_01_POST);
		blog01WithId.setId(300L);
		
		blog02 = criaPostBlog(DESCRICAO_02_POST, TITULO_02_POST);
		blog02.setId(300L);
		
		blog03 = criaPostBlog(DESCRICAO_03_POST, TITULO_03_POST);
		blog03.setId(301L);
		
		listagemTodosBlogPosts = new ArrayList<>();
		listagemTodosBlogPosts.add(blog01);
		listagemTodosBlogPosts.add(blog02);
		listagemTodosBlogPosts.add(blog03);
	}

	@Test
	public void salvarBlogPost() throws Exception {
		when(service.save(blog01)).thenReturn(blog01WithId);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String newBlogPostJSON = ow.writeValueAsString(blog01);

		this.mockMvc.perform(post("/v1/blog/").contentType(MediaType.APPLICATION_JSON).content(newBlogPostJSON))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().string(containsString(DESCRICAO_01_POST)));
	}
	
	@Test
	public void atualizarBlogPost() throws Exception {
		when(service.save(blog02)).thenReturn(blog02);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String newBlogPostJSON = ow.writeValueAsString(blog02);

		this.mockMvc.perform(put("/v1/blog/" + blog02.getId()).contentType(MediaType.APPLICATION_JSON).content(newBlogPostJSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(DESCRICAO_02_POST)));
	}

	@Test
	public void apagarBlogPost() throws Exception {

		Long idBlogPost = 301L;
		
		when(service.deleteById(idBlogPost)).thenReturn("ok");

		this.mockMvc.perform(delete("/v1/blog/" + idBlogPost).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("ok")));
	}
	
	@Test
	public void listaTodosOsBlogsPosts() throws Exception {

		when(service.findAll()).thenReturn(listagemTodosBlogPosts);

		this.mockMvc.perform(get("/v1/blog/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isPartialContent())
				.andExpect(content().string(containsString(DESCRICAO_01_POST)))
				.andExpect(content().string(containsString(DESCRICAO_02_POST)))
				.andExpect(content().string(containsString(DESCRICAO_03_POST)));
	}
	
	@Test
	public void recuperaUmUnicoBlogPostQueExiste() throws Exception {

		when(service.findById(blog01WithId.getId())).thenReturn(blog01WithId);

		this.mockMvc.perform(get("/v1/blog/" + blog01WithId.getId()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(DESCRICAO_01_POST)));
	}	
	
	@Test
	public void recuperaUmUnicoBlogPostQueNaoExiste() throws Exception {

		when(service.findById(blog01WithId.getId())).thenReturn(null);

		this.mockMvc.perform(get("/v1/blog/" + blog01WithId.getId()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	public void enviaIdInvalido() throws Exception {
		this.mockMvc.perform(get("/v1/blog/" + "ddd").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isInternalServerError());
	}
	
    public Blog criaPostBlog(String descricao, String titulo) {
    	return Blog.builder()
    			.dataPublicacao(new Date())
    			.descricao(descricao)
    			.titulo(titulo)
    			.build();
	}


}
