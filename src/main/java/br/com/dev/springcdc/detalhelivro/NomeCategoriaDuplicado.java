package br.com.dev.springcdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NomeCategoriaDuplicado implements Validator {
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm objeto = (CategoriaForm) target;
		
		boolean categoriaJaExiste = repository.existsByNomeCategoria(objeto.getNomeCategoria());
		 
		if(categoriaJaExiste) {
			errors.rejectValue("nomeCategoria", null, "A categoria " + objeto.getNomeCategoria() + " ja esta cadastrada");
		}
	}

}
