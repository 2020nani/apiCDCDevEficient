package br.com.dev.springcdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class CampoUnicoLivroValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LivroForm.class.isAssignableFrom(clazz);
	}

	public abstract boolean buscaLivroPorCampo(LivroForm livroform);

	@Override
	public void validate(Object target, Errors errors) {
		
		LivroForm objeto = (LivroForm) target;
		
		boolean livroJaExiste = buscaLivroPorCampo(objeto);
		
		if(livroJaExiste) {
			String nomeCampoInvalido = getNomeCampoInvalido();
			errors.rejectValue(nomeCampoInvalido, null, nomeCampoInvalido +  " : ja esta cadastrado");
		}
		
	}

	protected abstract String getNomeCampoInvalido();

	



}
