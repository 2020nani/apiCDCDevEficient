package br.com.dev.springcdc.detalhelivro;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

	@NotBlank
	private String nomeCategoria;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

		
}
