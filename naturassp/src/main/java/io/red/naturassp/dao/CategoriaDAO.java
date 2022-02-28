package io.red.naturassp.dao;

import io.red.naturassp.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDAO extends CrudRepository<Categoria, Long> {
    // Consultas customizadas
    // Por palavras-chave
    public List<Categoria> findByNomeContaining(String palavra);
}
