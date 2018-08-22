package com.leo.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {CoreConfig.class})
//@EnableJpaRepositories(basePackageClasses = {CoreConfig.class})
//@EntityScan(basePackageClasses = {CoreConfig.class})
public class CoreConfig {

}
