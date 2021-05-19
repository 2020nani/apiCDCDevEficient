package br.com.dev.springcdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IsbnUnicoValidator implements Validator {
	
	private LivroRepository livrorepository;
	
	
    

	public IsbnUnicoValidator(LivroRepository livrorepository) {
		this.livrorepository = livrorepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return LivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		LivroForm objeto = (LivroForm) target;
		
		boolean livroJaExiste = livrorepository.existsByIsbn(objeto.getIsbn());
		
		if(livroJaExiste) {
			errors.rejectValue("isbn", null, "O isbn " + objeto.getIsbn() + " ja existe");
		}
		
	}

	

}
