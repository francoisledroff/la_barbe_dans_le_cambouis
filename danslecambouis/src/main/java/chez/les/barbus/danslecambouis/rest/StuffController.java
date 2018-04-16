package chez.les.barbus.danslecambouis.rest;

import chez.les.barbus.danslecambouis.entity.Stuff;
import chez.les.barbus.danslecambouis.repository.StuffRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {

  @Autowired
  private StuffRepository stuffRepository;

  @GetMapping
  public List<Stuff> getStuff(Principal principal) {
    return stuffRepository.findByAuthor(principal.getName());
  }

  /*
   * The first step to protecting against CSRF attacks is to ensure your website uses proper HTTP verbs.
   * Specifically, before Spring Security’s CSRF support can be of use, you need to be certain
   * that your application is using PATCH, POST, PUT, and/or DELETE for anything that modifies state.
   *
   * cf. https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
   */
  @PostMapping
  public Stuff saveStuff(Principal principal, @RequestBody Stuff stuff) {
    stuff.setAuthor(principal.getName());
    return stuffRepository.save(stuff);
  }

  @PutMapping
  public Stuff updateStuff(Principal principal, @RequestBody Stuff stuff) {
    stuff.setAuthor(principal.getName());
    return stuffRepository.save(stuff);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void deleteStuff(Principal principal, @RequestBody Stuff stuff) {
    stuff.setAuthor(principal.getName());
     stuffRepository.delete(stuff);
  }

}
