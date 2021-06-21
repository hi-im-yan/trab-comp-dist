package br.com.trabalho.banco;


import javax.persistence.*;

@Entity
@Table(schema = "public", name = "loja")
public class Loja {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long gerente_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getGerente_id() {
        return gerente_id;
    }

    public void setGerente_id(Long gerente_id) {
        this.gerente_id = gerente_id;
    }
}
