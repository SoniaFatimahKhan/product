package com.jsp.product.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {

	Contact contact() {
		return new Contact().name("Sonia")
				.url("soniakhan.in")
				.email("soniask430@gmail.com");	
	}
	
    @Bean
    io.swagger.v3.oas.models.info.Info info() {
        return new io.swagger.v3.oas.models.info.Info().title("Product")
        		.description("RESTful API using CRUD operation")
        		.version("v1");
        		 		
    }

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(info());
    }
}
