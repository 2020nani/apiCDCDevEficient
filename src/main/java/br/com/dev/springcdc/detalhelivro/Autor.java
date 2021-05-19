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

	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now();
	public Autor (@NotBlank String nome, @NotBlank @URL String linkgithub) {

		this.nome = nome;
		this.linkgithub = linkgithub;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", linkgithub=" + linkgithub + "]";
	}
	
	

}
