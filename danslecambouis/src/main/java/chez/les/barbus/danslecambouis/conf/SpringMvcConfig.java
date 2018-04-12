package chez.les.barbus.danslecambouis.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

  public SpringMvcConfig() {
    super();
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    //the below is needed to have the ui loaded through a webjar
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // the below is working a 404 in the hard-coded path within the ui within the springfox webjar
    registry.addRedirectViewController("/configuration/ui",
        "/swagger-resources/configuration/ui");
    registry.addRedirectViewController("/configuration/security",
        "/swagger-resources/configuration/security");
  }

}
