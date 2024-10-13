package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Vendedor;

public record VendedorDados(int id,
                            String cargo,
                            int quantidade_vendas,
                            boolean status) {
    public VendedorDados(Vendedor vendedor) {
        this(Math.toIntExact(vendedor.getId()),
             vendedor.getCargo(),
             vendedor.getQuantidade_vendas(),
             vendedor.getStatus());
    }
}
