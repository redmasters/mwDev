package io.red.naturassp.service;

import io.red.naturassp.dao.PedidoDAO;
import io.red.naturassp.model.ItemPedido;
import io.red.naturassp.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoServiceImpl implements IPedidoService{
    @Autowired
    private PedidoDAO dao;


    @Override
    public Pedido inserirPedido(Pedido novo) {
        try {
            double total = 0.0;
            for(ItemPedido item: novo.getItensPedido()){
                item.setPrecoUnitario(item.getProduto().getPreco());

                //Desconto de 20% acima de 5 itens
                if(item.getQuantidadeItem() >= 5 ){
                    item.setPrecoTotal(item.getPrecoUnitario() * item.getQuantidadeItem() * 0.8);
                } else {
                    item.setPrecoTotal(item.getPrecoUnitario() * item.getQuantidadeItem());
                }
                total += item.getPrecoTotal();

            }
            for(ItemPedido item: novo.getItensPedido()){
                item.setPedido(novo);
            }
            novo.setValorTotal(total);
            dao.save(novo);
            return novo;
        } catch (Exception e){
            return null;
        }
    }
}
