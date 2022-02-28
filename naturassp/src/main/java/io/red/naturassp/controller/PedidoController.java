package io.red.naturassp.controller;

import io.red.naturassp.model.Pedido;
import io.red.naturassp.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    @Autowired
    protected IPedidoService service;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> inserNovoPedido(@RequestBody Pedido novo){
        novo = service.inserirPedido(novo);
        if(novo != null){
            return ResponseEntity.status(201).body(novo);
        } else {
            return ResponseEntity.status(400).build();
        }

    }
}
