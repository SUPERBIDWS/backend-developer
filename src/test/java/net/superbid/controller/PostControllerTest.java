package net.superbid.controller;

import static io.restassured.RestAssured.get;
import static io.restassured.http.ContentType.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostControllerTest {

	@Test
	public void buscaTodosOsPostEVerificaOCabecalhoResposta() {

		get("/post").then().statusCode(200).and().contentType(JSON);
	}

}
