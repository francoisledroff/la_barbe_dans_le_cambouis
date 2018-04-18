package chez.les.barbus.danslecambouis.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {


  @GetMapping
  public String getStuff() {
    return "soon we'll have stuff here";
  }

  /*
   * The first step to protecting against CSRF attacks is to ensure your website uses proper HTTP verbs.
   * Specifically, before Spring Security’s CSRF support can be of use, you need to be certain
   * that your application is using PATCH, POST, PUT, and/or DELETE for anything that modifies state.
   *
   * cf. https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
   */
  @PostMapping
  public String saveStuff() {
    return "soon we'll save stuff here";
  }

  @PutMapping
  public String updateStuff() {
    return "soon we'll update stuff here";
  }

  @RequestMapping()
  public String deleteStuff() {
    return "soon we'll delete stuff here";
  }

}
