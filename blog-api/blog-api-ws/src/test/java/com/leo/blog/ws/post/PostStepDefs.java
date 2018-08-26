package com.leo.blog.ws.post;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.leo.blog.commons.exception.InternalServerErrorException;
import com.leo.blog.commons.exception.NotFoundException;
import com.leo.blog.core.entity.Post;
import com.leo.blog.core.repository.PostRepository;
import com.leo.blog.core.services.PostService;
import com.leo.blog.ws.BlogApiStarter;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

@SpringBootTest(classes = BlogApiStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class PostStepDefs {
	
	@Autowired
    private TestRestTemplate template;
	
	private String id;
	
	private ResponseEntity<PostDTO> response;
	
	@Autowired
	@Mock
	private PostRepository postRepository;
	
	@Autowired
	@InjectMocks
	private PostService PostService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Dado("^o id do post \"([^\"]*)\"$")
	public void um_id_falho(String id) throws Throwable {
		this.id = id;
	}

	@Quando("^realizada uma consulta$")
	public void realizadaUmaConsulta() throws Throwable {
		Mockito.when(postRepository.findById(Mockito.anyInt()))
			   .thenReturn(Optional.of(new Post(1, LocalDateTime.of(2018, 8, 22, 21, 35, 10), "Post inicial", "Primeiro post do blog")));
		
		this.response = template.getForEntity("/post/" + id, PostDTO.class);
	}

	@Então("^deve retornar (\\d+) com os seguintes dados: (\\d+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void deveRetornarOPostComOsSeguintesDados(int statusCode, Integer id, String titulo, String dataPostagem, String descricao) throws Throwable {
		assertNotNull(response);
		assertEquals(statusCode, response.getStatusCodeValue());
		
		assertNotNull(response.getBody());
		assertEquals(id, response.getBody().getId());
		assertEquals(titulo, response.getBody().getTitulo());
		assertEquals(dataPostagem, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(response.getBody().getDataPublicacao()));
		assertEquals(descricao, response.getBody().getDescricao());
		
	}

	//404
	@Quando("^realizada uma requisiçao cujo resultado é um not found$")
	public void realizadaUmaRequisicaoCujoResultadoEUmNotFound() throws Throwable {
		Mockito.when(postRepository.findById(Mockito.anyInt())).thenThrow(new NotFoundException());
		this.response = template.getForEntity("/post/" + id, PostDTO.class);
	}

	// 400
	@Quando("^realizada uma requisiçao cujo resultado é um bad request$")
	public void realizadaUmaRequisicaoCujoResultadoEUmBadRequest() throws Throwable {
		this.response = template.getForEntity("/post/" + id, PostDTO.class);
	}
	
	//500
	@Quando("^realizada uma requisiçao cujo resultado é um erro do servidor$")
	public void realizadaUmaRequisicaoCujoResultadoEUmErroDoServidor() throws Throwable {
		Mockito.when(postRepository.findById(Mockito.anyInt())).thenThrow(new InternalServerErrorException());
		this.response = template.getForEntity("/post/" + id, PostDTO.class);
	}
	
	@Então("^deve retornar (\\d+)  e \"([^\"]*)\"$")
	public void deveRetornar(int statusCode, String statusMessage) throws Throwable {
		assertNotNull(response);
		assertEquals(statusCode, response.getStatusCodeValue());
		assertEquals(statusMessage, response.getStatusCode().getReasonPhrase());
		assertNotNull(response.getBody());
	}

}
