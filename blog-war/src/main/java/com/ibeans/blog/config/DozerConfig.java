package com.ibeans.blog.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by igotavares on 13/08/2018.
 */

@Configuration
public class DozerConfig {

    private static final String DOZER_MAPPING_FILE = "dozerJdk8Converters.xml";

    @Bean
    public static DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList(DOZER_MAPPING_FILE));
        return mapper;
    }

}
