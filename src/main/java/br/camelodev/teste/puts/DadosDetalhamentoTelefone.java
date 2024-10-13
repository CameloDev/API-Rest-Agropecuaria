package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Telefone;

public record DadosDetalhamentoTelefone(int id,
                                        String id_cliente,
                                        String id_fornecedor,
                                        String id_funcionario,
                                        String id_vendedor,
                                        String telefone) {
    public DadosDetalhamentoTelefone(Telefone telefone) {
        this(Math.toIntExact(telefone.getId()),
             telefone.getId_cliente(),
             telefone.getId_fornecedor(),
             telefone.getId_funcionario(),
             telefone.getId_vendedor(),
             telefone.getTelefone());
    }
}
