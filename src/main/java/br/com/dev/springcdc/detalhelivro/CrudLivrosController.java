package br.com.dev.springcdc.detalhelivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudLivrosController {
      @PersistenceContext
      private EntityManager entitymanager;
      
      @Autowired
      private AutorRepository autorrepository;
      
      @Autowired
      private LivroRepository livrorepository;
      
      @InitBinder
      public void init(WebDataBinder binder) {
    	  binder.addValidators(new IsbnUnicoValidator(livrorepository), new TituloUnicoValidator(livrorepository));
      }
      
      @PostMapping(value="/livros")
      @Transactional
      public String novoLivro(@Valid LivroForm livroform) {
    	 
		Livro livro = livroform.novoLivro(autorrepository, multiparFile -> {
			//funcao gera upload para cloud s3(ou outro qualquer)
			return "http://s3/bucket/nomeDoArquivoGerado";
		});
    	 entitymanager.persist(livro);
    	 return livro.toString();
      }
	
}
