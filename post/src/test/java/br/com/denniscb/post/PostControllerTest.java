package br.com.denniscb.post;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.denniscb.post.controller.PostController;
import br.com.denniscb.post.model.PostModel;
import br.com.denniscb.post.service.PostService;


@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PostService postService;

	@Test
	public void findAll() throws Exception {
		PostModel fakePost = new PostModel();
		fakePost.setTitulo("Post de teste");
		List<PostModel> fakePosts = Arrays.asList(fakePost);
		when(postService.findAll()).thenReturn(fakePosts);
		mockMvc.perform(get("/api/post").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].titulo", is(fakePost.getTitulo())));
	}
	
	@Test
	public void findById() throws Exception {
		Long id = 1L;
		PostModel fakePost = new PostModel();
		fakePost.setId(1L);
		when(postService.findById(id)).thenReturn(fakePost);
		mockMvc.perform(get("/api/post/id/"+ id.toString()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(fakePost.getId().intValue())));
	}
	
	@Test
	public void findByTitulo() throws Exception {
		PostModel fakePost = new PostModel();
		fakePost.setTitulo("Post de teste");
		String fragTitulo = "de";
		List<PostModel> fakePosts = Arrays.asList(fakePost);
		when(postService.findByTituloContaining(fragTitulo)).thenReturn(fakePosts);
		mockMvc.perform(get("/api/post/titulo/"+fragTitulo).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].titulo", is(fakePost.getTitulo())));
	}

}

	