package chez.les.barbus.danslecambouis.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableOAuth2Client
@EnableAuthorizationServer
@Order(6)
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  OAuthClientConfig oAuthClientConf;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http.antMatcher("/**").authorizeRequests().antMatchers("/swagger-resources/**",
        "/swagger-ui.html",
        "/v2/api-docs",
        "/", "/ping", "/login**", "/webjars/**").permitAll().anyRequest()
        .authenticated().and().exceptionHandling()
        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
        .logoutSuccessUrl("/").permitAll().and().csrf().disable()
        //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .addFilterBefore(oAuthClientConf.getSsoFilter(), BasicAuthenticationFilter.class);
    // @formatter:on
  }


  @Configuration
  @EnableResourceServer
  protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

      // @formatter:off
      http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/account/me").authenticated();
      // @formatter:on
    }
  }

  @Bean
  public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(filter);
    registration.setOrder(-100);
    return registration;
  }

}
