package chez.les.barbus.danslecambouis.rest;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

  @GetMapping()
  public String getAccount(Principal principal) {
    return "TODO account for principal "+principal.getName();
  }

}
