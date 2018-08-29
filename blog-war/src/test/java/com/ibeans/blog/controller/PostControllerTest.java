package com.ibeans.blog.controller;

import com.ibeans.blog.BlogConstants.PostConstants;
import com.ibeans.blog.application.PostService;
import com.ibeans.blog.dta.PostDTO;
import com.ibeans.blog.exception.PostNotFoundException;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by igotavares on 07/08/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    private static final int EMPTY = 0;
    private static final PostDTO POST_IS_NULL = null;

    @Autowired
    private MockMvc mvcMock;

    @MockBean
    private PostService postServiceMock;

    @Test
    public void shouldSaveAPost() throws Exception {
        String contet = "{\"title\":\"Welcome\",\"description\":\"to the new world\",\"publicationDate\":\"2018-01-01 00:00:00\"}";

        mvcMock.perform(post("/posts")
                            .content(contet)
                            .contentType(MediaType.APPLICATION_JSON_UTF8));

        PostDTO post = new PostDTO(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        verify(postServiceMock).save(post);
    }

    @Test
    public void givenASavedPost_thenShouldSeeThePostId() throws Exception {
        PostDTO post = new PostDTO(PostConstants.ID_IS_ONE);

        given(postServiceMock.save(any())).willReturn(post);

        String contet = "{\"title\":\"Welcome\",\"description\":\"to the new world\",\"publicationDate\":\"2018-01-01 00:00:00\"}";

        mvcMock.perform(post("/posts")
                .content(contet)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", is(PostConstants.ID_IS_ONE.intValue())));

    }

    @Test
    public void givenIdIsOne_thenShouldFindPostById() throws Exception {
        mvcMock.perform(get("/posts/{id}", PostConstants.ID_IS_ONE));

        verify(postServiceMock).findBy(PostConstants.ID_IS_ONE);
    }

    @Test
    public void givenAPostFound_thenShouldSeeThePost() throws Exception {
        PostDTO post = new PostDTO(PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        given(postServiceMock.findBy(PostConstants.ID_IS_ONE)).willReturn(post);

        mvcMock.perform(get("/posts/{id}", PostConstants.ID_IS_ONE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("id", is(PostConstants.ID_IS_ONE.intValue())))
                .andExpect(jsonPath("title", is(PostConstants.TITLE_IS_WELCOME)))
                .andExpect(jsonPath("description", is(PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD)))
                .andExpect(jsonPath("publicationDate", is(toString(PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00))));
    }

    @Test
    public void givenDoNotHavePost_thenShouldSeePostNotFound() throws Exception {
        given(postServiceMock.findBy(PostConstants.ID_IS_ONE)).willThrow(new PostNotFoundException());

        mvcMock.perform(get("/posts/{id}", PostConstants.ID_IS_ONE))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("No such Post"));
    }

    @Test
    public void shouldSearchAllPost() throws Exception {
        mvcMock.perform(get("/posts"));

        verify(postServiceMock).findAll();
    }

    @Test
    public void givenDoNotHavePost_thenItShouldGetEmptyList() throws Exception {
        given(postServiceMock.findAll()).willReturn(empty());

        mvcMock.perform(get("/posts").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void givenFoundAPost_shouldSeePost() throws Exception {
        PostDTO post = new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        given(postServiceMock.findAll()).willReturn(Lists.newArrayList(post));

        mvcMock.perform(get("/posts/").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(PostConstants.ID_IS_ONE.intValue())))
                .andExpect(jsonPath("$[0].title", is(PostConstants.TITLE_IS_WELCOME)))
                .andExpect(jsonPath("$[0].description", is(PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD)))
                .andExpect(jsonPath("$[0].publicationDate", is(toString(PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00))));
    }

    @Test
    public void givenFoundTwoPost_shouldSeePosts() throws Exception {
        PostDTO post = new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        PostDTO postTwo = new PostDTO(
                PostConstants.ID_IS_TWO,
                PostConstants.TITLE_IS_TITLE,
                PostConstants.DESCRIPTION_IS_DESCRIPTPION,
                PostConstants.PUBLICATION_DATE_IS_2017_02_03_10_05_03);

        given(postServiceMock.findAll()).willReturn(Lists.newArrayList(post, postTwo));

        mvcMock.perform(get("/posts/").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(PostConstants.ID_IS_ONE.intValue())))
                .andExpect(jsonPath("$[0].title", is(PostConstants.TITLE_IS_WELCOME)))
                .andExpect(jsonPath("$[0].description", is(PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD)))
                .andExpect(jsonPath("$[0].publicationDate", is(toString(PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00))))
                .andExpect(jsonPath("$[1].id", is(PostConstants.ID_IS_TWO.intValue())))
                .andExpect(jsonPath("$[1].title", is(PostConstants.TITLE_IS_TITLE)))
                .andExpect(jsonPath("$[1].description", is(PostConstants.DESCRIPTION_IS_DESCRIPTPION)))
                .andExpect(jsonPath("$[1].publicationDate", is(toString(PostConstants.PUBLICATION_DATE_IS_2017_02_03_10_05_03))));
    }

    @Test
    public void shouldUpdateThePost() throws Exception {
        String contet = "{\"title\":\"Welcome\",\"description\":\"to the new world\",\"publicationDate\":\"2018-01-01 00:00:00\"}";

        mvcMock.perform(put("/posts/{id}", PostConstants.ID_IS_ONE)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(contet))
                        .andExpect(status().isNoContent());

        PostDTO post = new PostDTO(PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        verify(postServiceMock).update(post , PostConstants.ID_IS_ONE);
    }

    @Test
    public void givenIdIsOne_thenShouldDeletePost() throws Exception {
        mvcMock.perform(delete("/posts/{id}", PostConstants.ID_IS_ONE))
                .andExpect(status().isNoContent());

        verify(postServiceMock).delete(PostConstants.ID_IS_ONE);
    }

    private List<PostDTO> empty() {
        return Lists.emptyList();
    }

    private String toString(LocalDateTime value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return value.format(formatter);
    }



}