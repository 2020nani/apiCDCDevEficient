package br.com.dev.springcdc.detalhelivro;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String titulo;
	
	@NotBlank
	@Size(max = 50)
	private String subtitulo;
	
	@Min(20)
	private BigDecimal preco;
	
	@NotBlank
	private String conteudo;
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@NotBlank
	@URL
	private String LinkCapaDoLivro;
	
	@NotNull
	@ManyToOne
    private Autor autor;
	
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	

	public Autor getAutor() {
		return autor;
	}
	
	

	public String getSubtitulo() {
		return subtitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getConteudo() {
		return conteudo;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}
	
	

	@Deprecated
	public Livro() {
		super();
	}

	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 50) String subtitulo,
			@Min(20) BigDecimal preco, @NotBlank String conteudo, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@NotBlank @URL @NotNull String LinkCapaDoLivro, @NotNull Autor autor) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.preco = preco;
		this.conteudo = conteudo;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.LinkCapaDoLivro = LinkCapaDoLivro;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", subtitulo=" + subtitulo + ", preco=" + preco + ", conteudo=" + conteudo
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", LinkCapaDoLivro=" + LinkCapaDoLivro
				+ ", autor=" + autor + "]";
	}

	
	
}
