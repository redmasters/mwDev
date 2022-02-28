package io.red.naturassp.service;

import io.red.naturassp.dao.ProdutoDAO;
import io.red.naturassp.model.Categoria;
import io.red.naturassp.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{
    @Autowired
    private ProdutoDAO dao;

    @Override
    public Produto inserirNovoProduto(Produto produto) {
        try {
            dao.save(produto);
            return produto;

        } catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        try {
           dao.save(produto);
        } catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>)dao.findAll();
    }

    @Override
    public Produto listarPorId(Long id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
    }

    @Override
    public List<Produto> listarDisponiveis() {
        return dao.findAllByDisponivel(true);
    }

    @Override
    public List<Produto> listarIndisponiveis() {
        return dao.findAllByDisponivel(false);
    }

    @Override
    public List<Produto> listarPorCategoria(Categoria categoria) {
        return dao.findAllByDisponivelAndCategoria(true, categoria);
    }
}
