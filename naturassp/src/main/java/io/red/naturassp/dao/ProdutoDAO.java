package io.red.naturassp.dao;

import io.red.naturassp.model.Categoria;
import io.red.naturassp.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoDAO extends CrudRepository<Produto, Long> {
    public List<Produto> findAllByDisponivel(boolean disponivel);
    public List<Produto> findAllByDisponivelAndCategoria(boolean disponivel, Categoria categoria);
    public List<Produto> findAllByCategoria(Categoria categoria);

}
