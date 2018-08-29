package com.ibeans.blog.application.shared;

import com.ibeans.blog.BlogConstants.PostConstants;
import com.ibeans.blog.config.DozerConfig;
import com.ibeans.blog.domain.post.Post;
import com.ibeans.blog.dta.PostDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by igotavares on 07/08/2018.
 */
public class ConverterTest {

    private Converter<Post, PostDTO> converter;

    @Before
    public void context() {
        this.converter = new Converter<>(DozerConfig.mapper(), Post.class, PostDTO.class);
    }

    @Test
    public void shouldConverteEntityToDTO() throws Exception {
        Post postToBeConverted = new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        PostDTO actual = converter.toDTO(postToBeConverted);

        PostDTO expected = new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldConverteDTOToEntity() throws Exception {
        PostDTO postToBeConverted = new PostDTO(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        Post actual = converter.toEntity(postToBeConverted);

        Post expected = new Post(
                PostConstants.ID_IS_ONE,
                PostConstants.TITLE_IS_WELCOME,
                PostConstants.DESCRIPTION_IS_TO_THE_NEW_WORLD,
                PostConstants.PUBLICATION_DATE_IS_2018_01_01_00_00_00);

        assertEquals(expected, actual);
    }

}