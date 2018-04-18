package chez.les.barbus.danslecambouis.conf;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter
{
  /**
   * Registers the KeycloakAuthenticationProvider with the authentication manager.
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
    keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
    auth.authenticationProvider(keycloakAuthenticationProvider);
  }

  /*
  Above we change the Granted Authority Mapper, by default in Spring Security,
  roles are prefixed with ROLE_, we could change that in our Realm configuration
  but it could be confusing for other applications that do not know this convention,
  so here we assign a SimpleAuthorityMapper that will make sure no prefix is added.
  */

  /**
   * Defines the session authentication strategy.
   */
  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }

  @Bean
  public KeycloakConfigResolver KeycloakConfigResolver() {return new KeycloakSpringBootConfigResolver();}

  /* keycloakConfigResolver Above:
   By default, the Keycloak Spring Security Adapter will look up for a file named keycloak.json
    present on your classpath. But here we want to leverage the Spring Boot properties file support.
   */

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    super.configure(http);



    //TODO play with crsf and other spring-security options
    //http
        //.csrf().disable();
        //.headers().disable()
        //.headers().frameOptions().sameOrigin();


    /*
    cf. https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#headers-cache-control
    Spring Security allows users to easily inject the default security headers to assist in protecting their application.
    The default for Spring Security is to include the following headers:

      Cache-Control: no-cache, no-store, max-age=0, must-revalidate
      Pragma: no-cache
      Expires: 0

      X-Content-Type-Options: nosniff

      Strict-Transport-Security: max-age=31536000 ; includeSubDomains
      X-Frame-Options: DENY
      X-XSS-Protection: 1; mode=block

     */

    //TODO add the correct user (look into Keycloak)
    http.authorizeRequests()
        .antMatchers("/account/*").hasRole("TODO")
        .anyRequest().permitAll();
  }

  /*configure above: Here is where we define our security constraints,
   pretty simple to understand we secure the path “/account” with role “api-user”
   */

}