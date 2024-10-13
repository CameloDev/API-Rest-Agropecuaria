package br.camelodev.teste.puts;

public record AtualizarDadosFornecedor(int id,
                                       String cnpj,
                                       String condicoes_de_pagamento,
                                       String data_registro,
                                       String departamento,
                                       String email,
                                       String nome,
                                       boolean status) {
}
