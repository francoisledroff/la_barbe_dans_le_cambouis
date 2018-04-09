package chez.les.barbus.danslecambouis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("chez.les.barbus.danslecambouis")
@SpringBootApplication
public class DanslecambouisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanslecambouisApplication.class, args);
	}
}