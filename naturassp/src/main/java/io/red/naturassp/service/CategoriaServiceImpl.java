package io.red.naturassp.service;

import io.red.naturassp.dao.CategoriaDAO;
import io.red.naturassp.model.Categoria;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CategoriaServiceImpl implements ICategoriaService {
    private Logger LOGGER;
    @Autowired
    private CategoriaDAO dao;

    @Override
    public Categoria inserirNovaCategoria(Categoria categoria) {
        try {
            if (categoria.getNome() != null && categoria.getNome().trim().length() > 0) {
                dao.save(categoria);
                return categoria;
            }
        } catch (IllegalArgumentException e) {
            LOGGER.info(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Categoria alterarCategoria(Categoria categoria) {
        try {
            if(categoria.getId() != null && categoria.getNome() != null && categoria.getNome().trim().length() > 0){
               dao.save(categoria);
               return categoria;
            }

        } catch (Exception e){
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Categoria> recuperarTodasCategorias() {
        return (List<Categoria>)dao.findAll();
    }

    @Override
    public List<Categoria> recuperarPorPalavraChave(String palavraChave) {
        if(palavraChave != null)
            return dao.findByNomeContaining(palavraChave);
        return Collections.emptyList();
    }
}
