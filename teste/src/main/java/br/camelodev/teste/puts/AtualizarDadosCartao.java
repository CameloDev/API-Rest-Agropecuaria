package br.camelodev.teste.puts;

import br.camelodev.teste.enums.tipo_cartao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record AtualizarDadosCartao(int id,
                                   String bandeira,
                                   String cvv,
                                   int id_cliente,
                                   String nome,
                                   String numero,
                                   boolean status_cartao,
                                   br.camelodev.teste.enums.tipo_cartao tipo_cartao,
                                   String validade_cartao) {
}
