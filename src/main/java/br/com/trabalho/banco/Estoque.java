package br.com.trabalho.banco;


import javax.persistence.*;

@Entity
@Table(schema = "public", name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long loja_id;

    @Column(nullable = false)
    private Long produto_id;

    @Column(nullable = false)
    private Float preco;

    @Column(nullable = false)
    private int quantidade;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getLoja_id() {
        return loja_id;
    }

    public void setLoja_id(Long loja_id) {
        this.loja_id = loja_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
