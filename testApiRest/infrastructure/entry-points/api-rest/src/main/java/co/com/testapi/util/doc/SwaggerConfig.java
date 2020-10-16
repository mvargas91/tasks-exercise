package co.com.testapi.util.doc; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.testapi.util.Constant;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig Swagger
 * @author milciades.vargas
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * customDocket custom Docket
	 * @return Docket.class
	 */
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("co.com.testapi.api.rest"))
                .paths(PathSelectors.any())
                .build().tags(
						new Tag(Constant.SERVICE_TASK_TAG,"All operations for the tasks")
                );
    }
    /**
     * Method for Api Information
     * @return ApiInfo
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API Documentation - Aplication Base")
                .description("T A S K S - API Description")
                .version("1.0")
                .build();
    }

}
