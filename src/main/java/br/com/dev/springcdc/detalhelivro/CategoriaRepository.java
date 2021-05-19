package br.com.dev.springcdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	boolean existsByNomeCategoria(String nomeCategoria);

}
