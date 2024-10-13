package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Fornecedor;

public record DadosDetalhamentoFornecedor(Long id,
                                          String cnpj,
                                          String condicoes_de_pagamento,
                                          String data_registro,
                                          String departamento,
                                          String email,
                                          String nome,
                                          boolean status) {
    public DadosDetalhamentoFornecedor(Fornecedor fornecedor) {
        this(fornecedor.getId(),
             fornecedor.getCnpj(),
             fornecedor.getCondicoes_pagamento(),
             fornecedor.getData_registro(),
             fornecedor.getDepartamento(),
             fornecedor.getEmail(),
             fornecedor.getNome(),
             fornecedor.getStatus());
    }
}
