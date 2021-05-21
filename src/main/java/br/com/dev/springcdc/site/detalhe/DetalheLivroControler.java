package br.com.dev.springcdc.site.detalhe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.dev.springcdc.detalhelivro.Livro;
import br.com.dev.springcdc.detalhelivro.LivroRepository;

@RestController
public class DetalheLivroControler {
	
	@Autowired
	private LivroRepository LivroRepository;

	@GetMapping(value = "/livro/{id}")
	public LivroDetalheDto getLivroNome(@PathVariable("id") Long id) {

		Livro livro = LivroRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao encontrado"));
		
		LivroDetalheDto livroDto = new LivroDetalheDto(livro);
		
		return livroDto;
		
	}

}
