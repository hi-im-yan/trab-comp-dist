package br.com.trabalho.banco;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long cargo_id;

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

    public Long getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(Long cargo_id) {
        this.cargo_id = cargo_id;
    }
}
