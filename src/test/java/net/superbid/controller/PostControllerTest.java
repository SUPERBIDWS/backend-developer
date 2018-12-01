package net.superbid.controller;

import static io.restassured.RestAssured.get;
import static io.restassured.http.ContentType.JSON;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

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
		get("/post").then().statusCode(200).and().contentType(JSON);
	}

}
