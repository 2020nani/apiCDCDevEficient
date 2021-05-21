package br.com.dev.springcdc.detalhelivro;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Function;

public class LivroForm {

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
	
	@NotNull
	private MultipartFile capa;
	
	@NotNull
	private Long autorId;

	public LivroForm(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 50) String subtitulo,
			@Min(20) BigDecimal preco, @NotBlank String conteudo, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull MultipartFile capa, @NotBlank Long autorId ) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.preco = preco;
		this.conteudo = conteudo;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.capa = capa;
		this.autorId = autorId;
	}

	public Livro novoLivro(AutorRepository autorrepository, Function<MultipartFile, String> funcaoUpload) {
		Autor autor= autorrepository.findById(autorId).get();
		String linkCapaLivro = funcaoUpload.apply(capa);
		return new Livro(this.titulo,this.subtitulo,this.preco, this.conteudo,this.numeroPaginas,this.isbn,linkCapaLivro,autor);
	}
	
	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
	}

	
}
