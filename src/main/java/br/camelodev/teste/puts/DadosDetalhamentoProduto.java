package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Produto;

public record DadosDetalhamentoProduto(int id,
                                       String nome,
                                       Float preco,
                                       String marca,
                                       String categoria,
                                       String data_adicao,
                                       Boolean status,
                                       int quantidade,
                                       String validade,
                                       String data_fabricacao,
                                       String codigo_barras,
                                       int id_fornecedor,
                                       int id_pedido) {
    public DadosDetalhamentoProduto(Produto produto) {
        this(Math.toIntExact(produto.getId()),
             produto.getNome(),
             produto.getPreco(),
             produto.getMarca(),
             produto.getCategoria(),
             produto.getData_adicao(),
             produto.getStatus(),
             produto.getQuantidade(),
             produto.getValidade(),
             produto.getData_fabricacao(),
             produto.getCodigo_barras(),
                Math.toIntExact(produto.getId_fornecedor()),
                Math.toIntExact(produto.getId_pedido()));
    }
}
