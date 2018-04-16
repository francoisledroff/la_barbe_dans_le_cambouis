package chez.les.barbus.danslecambouis.conf;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("chez.les.barbus.danslecambouis.rest"))
        .paths(PathSelectors.any())
        .build().apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("La barbe des APIs", "IPAs ou APIs ?",
        "TheBestOf", "Do What the Fuck you want",
        new Contact("Francois et Romain",
            "https://github.com/francoisledroff/la_barbe_dans_le_cambouis",
            "@francoisledroff"),
        "WTFPL", "http://www.wtfpl.net/", Collections.emptyList());
    return apiInfo;
  }
}