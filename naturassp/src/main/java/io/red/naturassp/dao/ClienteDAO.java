package io.red.naturassp.dao;

import io.red.naturassp.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {
    public Cliente findByEmailOrTelefone(String email, String telefone);
}
