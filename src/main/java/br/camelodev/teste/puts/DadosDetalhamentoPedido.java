package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Pedido;

public record DadosDetalhamentoPedido(int id,
                                      String datapedido,
                                      int id_cliente,
                                      int id_entrega,
                                      int id_vendedor,
                                      int preco_total,
                                      int quantidade_produtos,
                                      float taxa_entrega,
                                      br.camelodev.teste.enums.tipo_pagamento tipo_pagamento) {
    public DadosDetalhamentoPedido(Pedido pedido) {
        this(Math.toIntExact(pedido.getId()),
             pedido.getDatapedido(),
             pedido.getId_cliente(),
             pedido.getId_entrega(),
             pedido.getId_vendedor(),
             pedido.getPreco_total(),
             pedido.getQuantidade_produtos(),
             pedido.getTaxa_entrega(),
             pedido.getTipo_pagamento());
    }
}
