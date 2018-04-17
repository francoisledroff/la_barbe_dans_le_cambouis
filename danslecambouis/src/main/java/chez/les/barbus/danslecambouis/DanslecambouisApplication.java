package chez.les.barbus.danslecambouis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("chez.les.barbus.danslecambouis")
@SpringBootApplication
public class DanslecambouisApplication {

	public static void main(String[] args) {
		/*if ( System.getSecurityManager() == null )
			System.setSecurityManager(new PingSecurityManager());*/
		SpringApplication.run(DanslecambouisApplication.class, args);
	}

}
