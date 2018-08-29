package com.ibeans.blog.application.impl;

import com.ibeans.blog.BlogConstants.PostConstants;
import com.ibeans.blog.config.DozerConfig;
import com.ibeans.blog.domain.post.Post;
import com.ibeans.blog.domain.post.PostValidation;
import com.ibeans.blog.dta.PostDTO;
import com.ibeans.blog.infrastructure.jpa.PostRepository;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by igotavares on 07/08/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {

    @Mock
    private PostRepository repositoryMock;

    @Mock
    private PostValidation validationMock;

    private Mapper mapper;

    private PostServiceImpl postService;

    @Before
    public void context() {
        mapper = DozerConfig.mapper();
        postService = new PostServiceImpl(mapper, repositoryMock, validationMock);
    }

    @Test
    public void shouldSavePost() {
        PostDTO post = new PostDTO(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        postService.save(post);

        Post convertedPost = new Post(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        verify(repositoryMock).save(convertedPost);
    }

    @Test
    public void givenASavedPost_shouldReturnPostWithId() {
        Post savedPost = new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        given(repositoryMock.save(any())).willReturn(savedPost);

        PostDTO post = new PostDTO(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        PostDTO actual = postService.save(post);

        PostDTO expected = new PostDTO(PostConstants.ID_IS_ONE);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldValidatePostToChangeIt() {
        PostDTO post = new PostDTO(
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        postService.update(post, PostConstants.ID_IS_ONE);

        verify(validationMock).exists(PostConstants.ID_IS_ONE);
    }

    @Test
    public void shouldUpdate() {
        PostDTO post = new PostDTO(
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        postService.update(post, PostConstants.ID_IS_ONE);

        Post postToSave = new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        verify(repositoryMock).save(postToSave);
    }

    @Test
    public void shouldFindById() {
        Optional<Post> post = Optional.of(new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00));

        given(repositoryMock.findById(any())).willReturn(post);

        postService.findBy(PostConstants.ID_IS_ONE);

        verify(repositoryMock).findById(PostConstants.ID_IS_ONE);
    }

    @Test
    public void givenFoundPost_thenShouldReturn() {
        Optional<Post> post = Optional.of(new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00));

        given(repositoryMock.findById(any())).willReturn(post);

        PostDTO actual = postService.findBy(PostConstants.ID_IS_ONE);

        PostDTO expected = new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        postService.findAll();

        verify(repositoryMock).findAll();
    }

    @Test
    public void givenFoundPosts_thenShouldReturnThem() {
        Post post = new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        given(repositoryMock.findAll()).willReturn(asList(post));

        List<PostDTO> actual = postService.findAll();

        List<PostDTO> expected = asList(new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldValidatePostToSaveIt() {
        postService.delete(PostConstants.ID_IS_ONE);

        verify(validationMock).exists(PostConstants.ID_IS_ONE);
    }

    @Test
    public void shouldDeletePost() {
        postService.delete(PostConstants.ID_IS_ONE);

        verify(repositoryMock).deleteById(PostConstants.ID_IS_ONE);
    }

}