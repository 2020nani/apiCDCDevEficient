package br.com.dev.springcdc.site.detalhe;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.dev.springcdc.detalhelivro.Autor;
import br.com.dev.springcdc.detalhelivro.Livro;

public class LivroDetalheDto {
	
	private Long id;
	private String titulo;
	private DetalheAutorDto autor;
	private String conteudo;
	private String subtitulo;
	private BigDecimal preco;
	private String isbn;
	

	public LivroDetalheDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = new DetalheAutorDto(livro.getAutor());
		this.conteudo = livro.getConteudo();
		this.subtitulo = livro.getSubtitulo();
		this.preco = livro.getPreco();
		this.isbn = livro.getIsbn();
		//this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern(dd/MM/yyyy));
	}
	
	

	public Long getId() {
		return id;
	}



	public String getTitulo() {
		return titulo;
	}

	public DetalheAutorDto getAutor() {
		return autor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getIsbn() {
		return isbn;
	}

	 
}
