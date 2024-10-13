package br.camelodev.teste.posts;

public record ProdutoCadastro(int id,
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
}
