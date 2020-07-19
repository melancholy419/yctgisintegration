package com.babatunde.yctlocationintelligence.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(getApiInfo());
//				.components(new Components()
//				          .addSecuritySchemes("bearer-key", 
//				          new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")))
//				.addSecurityItem(
//	                    new SecurityRequirement().addList("bearer-key", Arrays.asList("read", "write")));
				
	}

	private Info getApiInfo() {
		return  new Info().description("Yaba College of Technology")
					.termsOfService("http://swagger.io/terms/")
					.title("Yabatech Locations")
					.version("Version 1 SNAPSHOT");
		
	}
	
	

}
