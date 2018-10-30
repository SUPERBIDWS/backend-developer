package com.test.sbws.blog;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.test.sbws.blog.dto.PostDTO;
import com.test.sbws.blog.rest.controller.PostController;
import com.test.sbws.blog.service.PostService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest(controllers = PostController.class)
public class PostControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PostService postService;

	@Test
	public void shouldSavePost() throws Exception {

		String request = "{\"title\" : \"Eleições 2018\",	\"description\" : \"Uma das eleições mais polarizadas.\"}";

		mockMvc.perform(post("/posts/").content(request)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());

	}

	@Test
	public void shouldUpdatePost() throws Exception {
		String request = "{\"title\" : \"Eleições 2016\",	\"description\" : \"Eleições municipais.\"}";

		mockMvc.perform(put("/posts/2").content(request)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isNoContent());
	}

	@Test
	public void givenAnIdShouldReturnPost() throws Exception {

		PostDTO postDTO = new PostDTO(PostConstants.ID_IS_ONE,
				LocalDateTime.now(), PostConstants.TITLE_IS_HELLO_WORLD,
				PostConstants.DESCRIPTION_IS_HELLO_WORLD);

		when(postService.findById(1l)).thenReturn(postDTO);

		mockMvc.perform(
				get("/posts/1").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("id", is(PostConstants.ID_IS_ONE.intValue())));

	}

	@Test
	public void givenPageAndSizeShouldReturnPosts() throws Exception {

		List<PostDTO> posts = Arrays.asList(
				new PostDTO(PostConstants.ID_IS_ONE, LocalDateTime.now(),
						PostConstants.TITLE_IS_HELLO_WORLD,
						PostConstants.DESCRIPTION_IS_HELLO_WORLD),
				new PostDTO(PostConstants.ID_IS_TWO, LocalDateTime.now(),
						PostConstants.TITLE_IS_HELLO_WORLD,
						PostConstants.DESCRIPTION_IS_HELLO_WORLD));

		when(postService.findAll(1, 10)).thenReturn(posts);

		mockMvc.perform(get("/posts/?page=1&size=10")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(PostConstants.ID_IS_ONE.intValue())))
				.andExpect(jsonPath("$[1].id", is(PostConstants.ID_IS_TWO.intValue())));
	}

	@Test
	public void givenAnIdShouldDeletePost() throws Exception {
		mockMvc.perform(
				delete("/posts/1").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isNoContent());
	}

}
