package br.com.dev.springcdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TituloUnicoValidator extends CampoUnicoLivroValidator {
	

	private LivroRepository livrorepository;

	public TituloUnicoValidator(LivroRepository livrorepository) {
		this.livrorepository = livrorepository;
	}

	@Override
	public boolean buscaLivroPorCampo(LivroForm livroform) {
		
		return livrorepository.existsByTitulo(livroform.getTitulo());
	}

	@Override
	protected String getNomeCampoInvalido() {
		
		return "titulo";
	}


}
