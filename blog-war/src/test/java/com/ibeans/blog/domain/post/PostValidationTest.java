package com.ibeans.blog.domain.post;

import com.ibeans.blog.BlogConstants.PostConstants;
import com.ibeans.blog.exception.PostNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by igotavares on 08/08/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class PostValidationTest {

    @Mock
    private PostSearch searchMock;

    @InjectMocks
    private PostValidation validation;

    @Before
    public void context() {
        given(searchMock.existsById(any())).willReturn(Boolean.TRUE);
    }

    @Test
    public void givenIdIsOne_thenShouldCheckIfThereIsAPostById() throws Exception {
        validation.exists(PostConstants.ID_IS_ONE);

        verify(searchMock).existsById(PostConstants.ID_IS_ONE);
    }

    @Test(expected = PostNotFoundException.class)
    public void givenThereIsNoPost_thenShouldThrowPostNotFound() throws Exception {
        given(searchMock.existsById(any())).willReturn(Boolean.FALSE);

        validation.exists(PostConstants.ID_IS_ONE);
    }

    @Test
    public void givenFoundAPost_thenShouldNotThrowAnException() throws Exception {
        given(searchMock.existsById(any())).willReturn(Boolean.TRUE);

        validation.exists(PostConstants.ID_IS_ONE);
    }

}