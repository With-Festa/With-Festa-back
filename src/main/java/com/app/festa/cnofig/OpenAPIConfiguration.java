package com.app.festa.cnofig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfiguration {

	private static final String API_NAME = "With - Festa";
	private static final String API_VERSION = "1.0.0";
	private static final String API_DESCRIPTION = "축제 또는 문화예술 공연 스케줄을 파악하기 위한 페이지 ";
	
	@Bean
	OpenAPI OpenAPIConfig() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
				.title(API_NAME)
				.description(API_DESCRIPTION)
				.version(API_VERSION));
	}
	
}
