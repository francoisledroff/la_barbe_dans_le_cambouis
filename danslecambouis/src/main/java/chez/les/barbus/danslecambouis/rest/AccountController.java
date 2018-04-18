package chez.les.barbus.danslecambouis.rest;

import chez.les.barbus.danslecambouis.dto.User;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

  @GetMapping("/id")
  public String id(Principal principal) {
    return principal.getName();
  }

  @GetMapping( "/me" )
  public User user(Principal principal) {
    return new User(principal.getName());
  }

}