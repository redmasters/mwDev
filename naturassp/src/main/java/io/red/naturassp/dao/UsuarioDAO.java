package io.red.naturassp.dao;

import io.red.naturassp.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
    Usuario findByUsernameOrEmail(String username, String email);
}
