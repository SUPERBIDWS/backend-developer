package net.superbid.controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.superbid.entity.Post;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import static io.restassured.http.ContentType.JSON;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {

	@LocalServerPort
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void buscaTodosOsPostEVerificaOCabecalhoResposta() {
		get("/blog/post").then().statusCode(200).and().contentType(JSON);
	}

	@Test
	public void buscaTodosOsPostsEVerificaOConteudo() {

		JsonPath jsonPath = given().header("Accept", "application/json").get("/blog/post").andReturn().jsonPath();

		Post post1 = jsonPath.getObject("posts[0]", Post.class);
		Post post2 = jsonPath.getObject("posts[1]", Post.class);
		assertEquals(1001l, post1.getId(), 00001);
		assertEquals(1002l, post2.getId(), 00001);
	}

	@Test
	public void buscaPostPorIdEVerificaConteudo() {

		JsonPath jsonPath = given().header("Accept", "application/json").get("/blog/post/1001")
				.andReturn().jsonPath();

		Post post = jsonPath.getObject("posts[0]", Post.class);
		assertEquals(1001l, post.getId(), 00001);

	}

}
