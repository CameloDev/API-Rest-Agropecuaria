package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Produto;

public record ProdutoDados(int id,
                           String nome,
                           Float preco,
                           String marca,
                           int quantidade) {
    public ProdutoDados(Produto produto) {
        this(Math.toIntExact(produto.getId()),
             produto.getNome(),
             produto.getPreco(),
             produto.getMarca(),
             produto.getQuantidade());
    }
}
