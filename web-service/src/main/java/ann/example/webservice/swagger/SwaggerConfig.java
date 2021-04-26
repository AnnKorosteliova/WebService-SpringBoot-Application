package ann.example.webservice.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("ann.example"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Account WebService API",
				"API for a WebService project",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ann Korosteliova", "https://github.com/AnnKorosteliova/WebService-SpringBoot-Application", "ann.korosteliova@gmail.com"), 
				"GitHub Code",
				"https://github.com/AnnKorosteliova/WebService-SpringBoot-Application",
				Collections.emptyList());
	}
	
	
}
