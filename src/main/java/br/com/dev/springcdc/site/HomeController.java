package br.com.dev.springcdc.site;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.springcdc.detalhelivro.LivroRepository;

@RestController
public class HomeController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/home")
	public Collection<LivroParaHome> lista() {
		return livroRepository.findAll().stream()
				.map(LivroParaHome::new)
				.collect(Collectors.toList());
	}
}
