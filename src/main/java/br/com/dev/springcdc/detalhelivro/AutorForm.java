package br.com.dev.springcdc.detalhelivro;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

public class AutorForm {

	@NotBlank
	private String nome;
	
	@NotBlank
	@URL
	private String linkgithub;
	
	@NotBlank
	private String descricao;

	public AutorForm(@NotBlank String nome, @NotBlank @URL String linkgithub, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.linkgithub = linkgithub;
		this.descricao = descricao;
	}

	public Autor novoAutor() {
		
		return new Autor(this.nome, this.linkgithub, this.descricao);
	}
	
	
}
