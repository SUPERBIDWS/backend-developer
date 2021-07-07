package com.sbws.blogserver.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbws.blogserver.model.Blog;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BlogRepositoryTest {
	
	public static final String DESCRICAO_01_POST = "Descricao do post teste";
	public static final String TITULO_01_POST = "Titulo do post teste";
	
	public static final String DESCRICAO_02_POST = "Descricao do post teste 2";
	public static final String TITULO_02_POST = "Titulo do post teste 2";
	
	public static final String DESCRICAO_03_POST = "Descricao do post teste 3";
	public static final String TITULO_03_POST = "Titulo do post teste 3";

	public static final Long ID_DOES_NOT_EXIST = 9998973L;
	
	Blog blog01 = null;
	Blog blog02 = null;
	Blog blog03 = null;

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private BlogRepository repository;
    
    @Before
    public void loadDatabase() {
        blog01 = criaPostBlog(DESCRICAO_01_POST, TITULO_01_POST);
        entityManager.persist(blog01);
        
        blog02 = criaPostBlog(DESCRICAO_02_POST, TITULO_02_POST);
        entityManager.persist(blog02);
        
        entityManager.flush();
    }
    

    @Test
    public void whenSaveBlog_thenReturnBlogPostWithId() {
        // given
        blog03 = criaPostBlog(DESCRICAO_03_POST, TITULO_03_POST);
        repository.save(blog03);
        
		// when
        Optional<Blog> result = repository.findById(blog03.getId());
     
        // then
        assertThat(result.isPresent()).isEqualTo(true);
        assertThat(result.get().getId()).isEqualTo(blog03.getId());
    }

    @Test
    public void whenFindAll_thenReturnAllBlogPost() {
        // given at @Before
        
		// when
        List<Blog> result = (List<Blog>) repository.findAll();
     
        // then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }
    
    @Test
    public void whenFindByIdThatExist_thenReturnOneBlogPost() {
        // given at @Before
        
		// when
        Optional<Blog> result = repository.findById(blog01.getId());
     
        // then
        assertThat(result.isPresent()).isEqualTo(true);
        assertThat(result.get().getId()).isEqualTo(blog01.getId());
    }
    
    @Test
    public void whenFindByIdThatDoesNotExist_thenReturnNullBlogPost() {
    	// given
    	
    	// when
    	Optional<Blog> result = repository.findById(ID_DOES_NOT_EXIST);
    	
    	// then
    	assertThat(result.isPresent()).isEqualTo(false);
    }
    
    public Blog criaPostBlog(String descricao, String titulo) {
    	return Blog.builder()
    			.dataPublicacao(new Date())
    			.descricao(descricao)
    			.titulo(titulo)
    			.build();
	}
    
}

