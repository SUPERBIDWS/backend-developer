package br.com.denniscb.post;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.denniscb.post.controller.PostController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostApplicationTests {

	@Autowired
	private PostController postController;
		
	@Test
	public void contextLoads() throws Exception {
		assertThat(postController).isNotNull();
	}

}
