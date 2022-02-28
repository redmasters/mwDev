package io.red.naturassp.dao;

import io.red.naturassp.model.Cliente;
import io.red.naturassp.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PedidoDAO extends CrudRepository<Pedido, Long> {
    public ArrayList<Pedido> findAllByCliente(Cliente cliente);
}
