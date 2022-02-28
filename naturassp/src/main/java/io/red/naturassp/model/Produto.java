package io.red.naturassp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produto")
public class Produto {
    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "nome_produto", length = 100, nullable = false)
    private String nome;

    @Column(name = "detalhe_produto", length = 500)
    private String detalhe;

    @Column(name = "foto_produto", length = 255, nullable = false)
    private String fotoProduto;

    @Column(name = "preco_produto", nullable = false)
    private double preco;

    @Column(name = "disponivel_produto")
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
