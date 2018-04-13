package chez.les.barbus.danslecambouis.rest;

import chez.les.barbus.danslecambouis.dto.Stuff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {

  @GetMapping
  public String getStuff() {
    return "Soon here, you'll get your stuff";
  }

  /*
   * The first step to protecting against CSRF attacks is to ensure your website uses proper HTTP verbs.
   * Specifically, before Spring Security’s CSRF support can be of use, you need to be certain
   * that your application is using PATCH, POST, PUT, and/or DELETE for anything that modifies state.
   *
   * cf. https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
   */
  @PostMapping
  public String postStuff(@RequestBody Stuff stuff) {
    return "Thanks for posting this stuff:  "+stuff;
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public String deleteStuff(@RequestBody Stuff stuff) {
    return "Soon we'll delete this stuff: "+stuff;
  }

}
