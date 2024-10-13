package br.camelodev.teste.puts;

public record AtualizarDadosEntrega(int id,
                                    String data_envio,
                                    int id_endereco,
                                    int id_fornecedor,
                                    String metodo_envio,
                                    String observacao,
                                    String status_entrega,
                                    float taxa_entrega) {
}
