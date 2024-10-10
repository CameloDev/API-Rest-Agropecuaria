package br.camelodev.teste.posts;

public record VendedorCadastro(int id,
                               String cargo,
                               String codigo_vendedor,
                               float comissao_vendas,
                               String data_contratacao,
                               int id_funcionario,
                               int meta_vendas,
                               int quantidade_vendas,
                               boolean status) {
}
