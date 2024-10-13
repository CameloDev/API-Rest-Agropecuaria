package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Entrega;

public record DadosDetalhamentoEntrega(int id,
                                       String data_envio,
                                       Long id_endereco,
                                       Long id_fornecedor,
                                       br.camelodev.teste.enums.metodo_envio metodo_envio,
                                       String observacao,
                                       br.camelodev.teste.enums.status_entrega status_entrega,
                                       float taxa_entrega) {
    public DadosDetalhamentoEntrega(Entrega entrega) {
        this(Math.toIntExact(entrega.getId()),
             entrega.getData_envio(),
             entrega.getId_endereco(),
             entrega.getId_fornecedor(),
             entrega.getMetodo_envio(),
             entrega.getObservacao(),
             entrega.getStatus_entrega(),
             entrega.getTaxa_entrega());
    }
}