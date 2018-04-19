package chez.les.barbus.danslecambouis.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
public class PingController {

  @GetMapping()
  public String ping(HttpServletRequest request, HttpServletResponse response) {
	System.out.println(request.getContextPath());
	System.out.println(request.getRequestURL());
	System.out.println(request.getParameterMap());
    return "pong";
  }

}
