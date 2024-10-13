package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Vendedor;

public record DadosDetalhamentoVendedor(int id,
                                        String cargo,
                                        String codigo_vendedor,
                                        float comissao_vendas,
                                        String data_contratacao,
                                        int id_funcionario,
                                        int meta_vendas,
                                        int quantidade_vendas,
                                        boolean status) {
    public DadosDetalhamentoVendedor(Vendedor vendedor) {
        this(Math.toIntExact(vendedor.getId()),
                vendedor.getCargo(),
                vendedor.getCodigo_vendedor(),
                vendedor.getComissao_vendas(),
                vendedor.getData_contratacao(),
                Math.toIntExact(vendedor.getId_funcionario()),
                vendedor.getMeta_vendas(),
                vendedor.getQuantidade_vendas(),
                vendedor.getStatus());
    }
}
