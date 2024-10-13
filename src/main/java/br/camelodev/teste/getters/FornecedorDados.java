package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Fornecedor;

public record FornecedorDados(Long id,
                              String cnpj,
                              String nome,
                              boolean status) {
    public FornecedorDados(Fornecedor fornecedor) {
        this((long) fornecedor.getId(),
             fornecedor.getCnpj(),
             fornecedor.getNome(),
             fornecedor.getStatus());
    }
}
