package br.com.dev.springcdc.detalhelivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CrudAutoresController {
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@PostMapping(value="/autores")
	@Transactional
	public String novoAutor(@RequestBody @Valid AutorForm autorform) {
		Autor autor = autorform.novoAutor();
		entitymanager.persist(autor);
		return autor.toString();
	}

}
