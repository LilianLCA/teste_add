package br.com.testeadd.teste_add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class TesteAddApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteAddApplication.class, args);
	}
	
	@GetMapping
	public ModelAndView swaggerUi () {
			return new ModelAndView("redirect:/swagger-ui/");
		}
}
