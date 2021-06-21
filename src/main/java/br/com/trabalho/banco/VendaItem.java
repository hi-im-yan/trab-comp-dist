package br.com.trabalho.banco;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "venda_item")
public class VendaItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long venda_id;

    @Column(nullable = false)
    private Long produto_id;

    @Column(nullable = false)
    private Long usuario_id;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private Float preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(Long venda_id) {
        this.venda_id = venda_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
