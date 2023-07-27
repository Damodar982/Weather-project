package com.omnify.project.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket libraryAPi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("weather-service")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.omnify.project"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Library-API")
				.description("Library API reference for develeopers")
				.termsOfServiceUrl("http://fakeLibrary.com")
				.contact(new Contact("LibraryPI","http://fakeLibrary.com","fakeLibrary@gmail.com"))
				.license("Library License")
				.licenseUrl("http://fakeLibrary.com")
				.version("1.0")
				.build();
	}
}
