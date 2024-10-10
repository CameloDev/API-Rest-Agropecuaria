package br.camelodev.teste.posts;

public record PedidoCadastro(int id,
                             String datapedido,
                             int id_cliente,
                             int id_entrega,
                             int id_vendedor,
                             int preco_total,
                             int quantidade_produtos,
                             float taxa_entrega,
                             String tipo_pagamento) {
}
