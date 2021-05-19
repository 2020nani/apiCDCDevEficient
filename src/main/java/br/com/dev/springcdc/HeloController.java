package br.com.dev.springcdc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
	
	@GetMapping(value = "/api/teste")
	public String teste() {
		return "hello world";
	}

}
