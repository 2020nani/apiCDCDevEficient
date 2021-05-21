package br.com.dev.springcdc.site.detalhe;


import br.com.dev.springcdc.detalhelivro.Autor;

public class DetalheAutorDto  {
	
	
	private String nome;

	private String linkgithub;

	private String descricao;


	


	public DetalheAutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.linkgithub = autor.getLinkgithub();
		this.descricao = autor.getDescricao();
	}


	public String getNome() {
		return nome;
	}


	public String getLinkgithub() {
		return linkgithub;
	}


	public String getDescricao() {
		return descricao;
	}
	
	

}
