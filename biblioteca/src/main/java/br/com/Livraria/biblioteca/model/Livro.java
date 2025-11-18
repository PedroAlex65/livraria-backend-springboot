package br.com.Livraria.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_livro", nullable = false)
    private String nomeLivro;

    //1. Para o JPA é obrigatorio ter um construtor vazio!
    public Livro() {
    }

    //2. Construtor para a criação(Para usar no Service)
    public Livro(String nomeDoLivro) {
        this.nomeLivro = nomeDoLivro;
    }

    //3. Get(Para ler os Dados da Entidade)
    public Long getId() {
        return id;
    }

    public String getNomeLivro() {
        return this.nomeLivro;
    }

    //4. Set(Para setar o valor)
    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
}
