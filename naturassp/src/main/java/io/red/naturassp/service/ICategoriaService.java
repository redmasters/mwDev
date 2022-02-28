package io.red.naturassp.service;

import io.red.naturassp.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    // Recebe uma categoria com um nome e insere no banco
    public Categoria inserirNovaCategoria(Categoria categoria);

    // Altera categoria
    public Categoria alterarCategoria(Categoria categoria);

    // Recuperar as todas as categorias sem filtro
    public List<Categoria> recuperarTodasCategorias();

    // Busca por palavra chave
    public List<Categoria> recuperarPorPalavraChave(String palavraChave);

}
