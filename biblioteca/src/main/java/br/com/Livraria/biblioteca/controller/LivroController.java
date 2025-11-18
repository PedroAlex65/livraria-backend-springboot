package br.com.Livraria.biblioteca.controller;

import br.com.Livraria.biblioteca.model.Livro;
import br.com.Livraria.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")

public class LivroController {
    //Injetar a dependencia
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    //SETAR --> MÉTODO POSTING
    @PostMapping
    public void adicionarLivro(@RequestBody String livro) {
        this.livroService.addLivro(livro);
    }

    @GetMapping
    public List<Livro> buscarLivros(@RequestParam(required = false) String nomeDoLivro) {
        return this.livroService.buscarLivro(nomeDoLivro);
    }

    @DeleteMapping
    public void deletarLivro() {
        this.livroService.removerLivro();
    }

    //GetLeitura

}
