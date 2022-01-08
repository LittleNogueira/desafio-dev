package br.com.bycoders.desafiodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DesafioDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDevApplication.class, args);
	}

}
