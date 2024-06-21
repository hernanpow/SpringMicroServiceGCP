package com.boot.challengue;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@Configuration
@OpenAPIDefinition(
		info = @Info(
				title = "pinApp BackEnd Challenge",
				version ="1.0.0",
				description = "Endpoints for pinApp Challenge"
				)	
		)
public class SwaggerConfig {
    

}
