package com.leo.ws;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.leo.core.CoreConfig;

@Configuration
//@EnableSwagger2
@ComponentScan(basePackageClasses = {APIConfig.class})
@Import({CoreConfig.class})
public class APIConfig {
	

	// add swagger
}
