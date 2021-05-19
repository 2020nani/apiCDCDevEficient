package br.com.dev.springcdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

	boolean existsByIsbn(String isbn);

	boolean existsByTitulo(String titulo);

}
