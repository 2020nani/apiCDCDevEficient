package br.com.dev.springcdc.detalhelivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudCategoriaController {
	
	@PersistenceContext
	private EntityManager entitymanager;
	@Autowired
	private NomeCategoriaDuplicado nomeCategoriaDuplicado;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeCategoriaDuplicado);
	}
	
	@PostMapping(value="/categorias")
	@Transactional
	public String novaCategoria(@RequestBody @Valid CategoriaForm categoriaform) {
		Categoria categoria = new Categoria(categoriaform.getNomeCategoria());
		entitymanager.persist(categoria);
		return categoria.toString();
	}

}
