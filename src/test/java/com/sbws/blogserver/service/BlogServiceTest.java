package com.sbws.blogserver.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbws.blogserver.model.Blog;
import com.sbws.blogserver.repository.BlogRepository;

@RunWith(SpringRunner.class)
public class BlogServiceTest {
	
	@TestConfiguration
    static class BlogServiceImplTestContextConfiguration {
  
        @Bean
        public BlogService employeeService() {
            return new BlogServiceImpl();
        }
    }
 
    @Autowired
    private BlogService service;
 
    @MockBean
    private BlogRepository repository;
    
    private Blog blog01 = null;
    private Blog blog02 = null;
    private Blog blog03 = null;
    private Blog blogWithoutId = null;
    private Blog blogWithId = null;
    
	public static final String DESCRICAO_01_POST = "Descricao do post teste";
	public static final String TITULO_01_POST = "Titulo do post teste";
	
	public static final String DESCRICAO_02_POST = "Descricao do post teste 2";
	public static final String TITULO_02_POST = "Titulo do post teste 2";
	
	public static final String DESCRICAO_03_POST = "Descricao do post teste 3";
	public static final String TITULO_03_POST = "Titulo do post teste 3";
	
	public static final String DESCRICAO_04_POST = "Descricao do post teste WithoutId";
	public static final String TITULO_04_POST = "Titulo do post teste WithoutId";
	
	public static final String DESCRICAO_05_POST = "Descricao do post teste WithId";
	public static final String TITULO_05_POST = "Titulo do post teste WithId";
	
    
    @Before
    public void setUp() {
        blog01 = criaPostBlog(DESCRICAO_01_POST, TITULO_01_POST);
        blog02 = criaPostBlog(DESCRICAO_02_POST, TITULO_02_POST);
        blog03 = criaPostBlog(DESCRICAO_03_POST, TITULO_03_POST);
        blogWithoutId = criaPostBlog(DESCRICAO_04_POST, TITULO_04_POST);
        blogWithId = criaPostBlog(DESCRICAO_05_POST, TITULO_05_POST);
        blogWithId.setId(5L);
     
        List<Blog> listBlogPosts = new ArrayList<>();
        listBlogPosts.add(blog01);
        listBlogPosts.add(blog02);
        listBlogPosts.add(blog03);
        
        Mockito.when(repository.findById(blog01.getId())).thenReturn(Optional.of(blog01));
		Mockito.when(repository.findAll()).thenReturn(listBlogPosts);
		Mockito.when(repository.save(blogWithoutId)).thenReturn(blogWithId);
		
    	BlogRepository myRepositoy = mock(BlogRepository.class);
    	doNothing().when(myRepositoy).deleteById(blogWithId.getId());		
    }
    
    @Test
    public void whenDelete_thenBlogPostShouldBeDeleted() {
        String found = service.deleteById(blogWithId.getId());
        
        assertThat(found).isNotNull();
        assertThat(found).isEqualTo("ok");
    }

    @Test
    public void whenSave_thenBlogPostShouldBeReturnedWithId() {
        Blog found = service.save(blogWithoutId);
      
        assertThat(found.getId()).isNotNull();
    }
    
    @Test
    public void whenFindById_thenBlogPostShouldBeFound() {
        Blog found = service.findById(blog01.getId());
      
        assertThat(found.getId()).isEqualTo(blog01.getId());
    }
    
    @Test
    public void whenFindAll_thenListBlogPostShouldBeFound() {
        List<Blog> found = service.findAll();
      
        assertThat(found.size()).isGreaterThanOrEqualTo(2);
     }
    
    public Blog criaPostBlog(String descricao, String titulo) {
    	return Blog.builder()
    			.dataPublicacao(new Date())
    			.descricao(descricao)
    			.titulo(titulo)
    			.build();
	}

}
