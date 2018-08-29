package com.ibeans.blog.infrastructure.jpa;

import com.ibeans.blog.BlogApplication;
import com.ibeans.blog.BlogConstants.PostConstants;
import com.ibeans.blog.domain.post.Post;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by igotavares on 07/08/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository repository;

    @Before
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    public void shouldFindPost() {
        Post post = new Post(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        Post savedPost = repository.save(post);

        Optional<Post> postFound = repository.findById(savedPost.getId());

        assertThat(postFound.orElse(null), create(PostConstants.TITLE_IS_WELCOME,
                                                        PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                                                        PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00));
    }

    @Test
    public void shouldFindAll() {
        Post post = new Post(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        repository.save(post);

        List<Post> posts = repository.findAll();

        assertThat(posts, contains(create(PostConstants.TITLE_IS_WELCOME,
                                          PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                                          PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00)));
    }

    @Test
    public void shouldUpdate() {
        Post post = new Post(
                PostConstants.TITLE_IS_TITLE,
                PostConstants.DESCRIPTION_IS_DESCRIPTPION,
                PostConstants.PUBLICATION_DATE_IS_2017_02_03_10_05_03);

        post = repository.save(post);

        post = new Post(
                post.getId(),
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        repository.save(post);

        List<Post> posts = repository.findAll();

        assertThat(posts, contains(create(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00)));
    }


    @Test
    public void shouldDelete() {
        Post post = new Post(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        post = repository.save(post);

        repository.deleteById(post.getId());

        List<Post> posts = repository.findAll();

        assertThat(posts, empty());
    }

    private Matcher<Post> create(String title, String description, LocalDateTime publicationDate) {
        return allOf(hasProperty("id", notNullValue()),
                hasProperty("title", is(title)),
                hasProperty("description", is(description)),
                hasProperty("publicationDate", is(publicationDate))
        );
    }

}