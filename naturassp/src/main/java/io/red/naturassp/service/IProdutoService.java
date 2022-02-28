package io.red.naturassp.service;

import io.red.naturassp.model.Categoria;
import io.red.naturassp.model.Produto;

import java.util.List;

public interface IProdutoService {
    public Produto inserirNovoProduto(Produto produto);
    public Produto alterarProduto(Produto produto);
    public List<Produto> listarTodos();
    public Produto listarPorId(Long id);
    public List<Produto> listarDisponiveis();
    public List<Produto> listarIndisponiveis();
    public List<Produto> listarPorCategoria(Categoria categoria);

}
