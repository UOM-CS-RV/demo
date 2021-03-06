package mt.edu.um.cs.rv.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	   @Bean
	    public Docket demoApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
	                .pathMapping("/")
//	                .directModelSubstitute(LocalDate.class,
//	                                       String.class)
//	                .genericModelSubstitutes(ResponseEntity.class)
	                ;
	    }

	    @Bean
	    UiConfiguration uiConfig() {
	        return new UiConfiguration(
	                "validatorUrl",// url
	                "none",       // docExpansion          => none | list
	                "alpha",      // apiSorter             => alpha
	                "schema",     // defaultModelRendering => schema
	                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
	                false,        // enableJsonEditor      => true | false
	                true);        // showRequestHeaders    => true | false
	    }
}
