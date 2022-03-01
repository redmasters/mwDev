package io.red.naturassp.service;

import io.red.naturassp.dao.UsuarioDAO;
import io.red.naturassp.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService {
    private final UsuarioDAO dao;

    public UsuarioServiceImpl(UsuarioDAO dao) {
        this.dao = dao;
    }

    @Override
    public Usuario recuperarUsuario(Usuario original) {
        return dao.findByUsernameOrEmail(original.getUsername(), original.getEmail());
    }

}
