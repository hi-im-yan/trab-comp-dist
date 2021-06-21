package br.com.trabalho.banco;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "venda")
public class Venda {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long loja_id;

    @Column(nullable = false)
    private Long usuario_id;

    @Column(nullable = false)
    private String nome_cliente;

    @Column(nullable = false)
    private Float valor_total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoja_id() {
        return loja_id;
    }

    public void setLoja_id(Long loja_id) {
        this.loja_id = loja_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Float getValor_total() {
        return valor_total;
    }

    public void setValor_total(Float valor_total) {
        this.valor_total = valor_total;
    }
}
