package com.leo.blog.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({APIConfig.class})
public class BlogApiStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApiStarter.class, args);
	}
}
