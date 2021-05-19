package br.com.dev.springcdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TituloUnicoValidator implements Validator {
	

	private LivroRepository livrorepository;

	public TituloUnicoValidator(LivroRepository livrorepository) {
		this.livrorepository = livrorepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return LivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		LivroForm objeto = (LivroForm) target;
		
		boolean tituloJaExiste = livrorepository.existsByTitulo(objeto.getTitulo());
		
		if(tituloJaExiste) {
			errors.rejectValue("titulo", null, "O titulo " + objeto.getTitulo() + " nao esta disponivel");
		}

	}

}
