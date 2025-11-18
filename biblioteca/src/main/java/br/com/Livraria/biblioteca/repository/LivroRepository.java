package br.com.Livraria.biblioteca.repository;

import br.com.Livraria.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findTopByOrderByIdDesc();
    List<Livro> findByNomeLivroContaining(String nomeLivro);
}
