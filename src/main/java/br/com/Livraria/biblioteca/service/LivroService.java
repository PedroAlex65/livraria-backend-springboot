package br.com.Livraria.biblioteca.service;

import br.com.Livraria.biblioteca.model.Livro;
import br.com.Livraria.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //Adicionar Tarefa
    public void addLivro(String nomeLivro) {
        if (nomeLivro == null || nomeLivro.trim().isEmpty()) {
            return;
        }
        Livro livro = new Livro(nomeLivro);
        livroRepository.save(livro);
    }

    //Excluir Ultimo
    public void removerLivro() {
        Optional<Livro> livroOptional = livroRepository.findTopByOrderByIdDesc();
        if (livroOptional.isPresent()) {
            Livro livroReal = livroOptional.get();
            livroRepository.delete(livroReal);
        }
    }

    //Buscar
    public List<Livro> buscarLivro(String nomeLivro){
        if(nomeLivro == null || nomeLivro.trim().isEmpty()){
            return livroRepository.findAll();
        }
      List<Livro> livroContain = livroRepository.findByNomeLivroContaining(nomeLivro);
      return  livroContain;
    }
}
