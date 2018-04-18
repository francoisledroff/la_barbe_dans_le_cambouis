package chez.les.barbus.danslecambouis.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
public class PingController {

	private static final Path LOG_FILE = Paths.get("/var/log/ping.log");

	@GetMapping()
	public String ping() {
		try {
			Files.write(Paths.get("/var/log/ping.log"), ("Called!").getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Can't log :/");
			//e.printStackTrace();
		}
		return "pong";
	}

}
