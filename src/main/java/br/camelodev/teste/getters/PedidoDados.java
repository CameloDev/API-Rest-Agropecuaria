package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Pedido;

public record PedidoDados(int id,
                          int id_cliente,
                          int preco_total,
                          float taxa_entrega) {
    public PedidoDados(Pedido pedido) {
        this(Math.toIntExact(pedido.getId()),
             pedido.getId_cliente(),
             pedido.getPreco_total(),
             pedido.getTaxa_entrega());
    }
}
