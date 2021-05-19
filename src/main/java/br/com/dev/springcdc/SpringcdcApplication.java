package br.com.dev.springcdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.dev.springcdc.shared.configuration.SwaggerConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringcdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcdcApplication.class, args);
	}

}
