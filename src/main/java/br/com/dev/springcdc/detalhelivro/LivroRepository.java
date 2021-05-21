package br.com.dev.springcdc.detalhelivro;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

	boolean existsByIsbn(String isbn);

	boolean existsByTitulo(String titulo);
	
	@Override
	Collection<Livro> findAll();

}
