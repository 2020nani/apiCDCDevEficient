package br.com.dev.springcdc.detalhelivro;

import org.springframework.stereotype.Component;

@Component
public class IsbnUnicoValidator extends CampoUnicoLivroValidator {
	
	private LivroRepository livroRepository;

	public IsbnUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean buscaLivroPorCampo(LivroForm livroform) {
		
		return livroRepository.existsByIsbn(livroform.getIsbn());
	}

	@Override
	protected String getNomeCampoInvalido() {
		
		return "isbn";
	}
	
	

}
