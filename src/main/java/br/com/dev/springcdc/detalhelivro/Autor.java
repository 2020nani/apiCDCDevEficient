package br.com.dev.springcdc.detalhelivro;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@URL
	private String linkgithub;
	
	@NotBlank
	private String descricao;

	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
	
	}

	public Autor (@NotBlank String nome, @NotBlank @URL String linkgithub, @NotBlank String descricao) {

		this.nome = nome;
		this.linkgithub = linkgithub;
		this.descricao = descricao;
	}

	

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", linkgithub=" + linkgithub + ", descricao=" + descricao + "]";
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
