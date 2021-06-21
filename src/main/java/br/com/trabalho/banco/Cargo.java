package br.com.trabalho.banco;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
