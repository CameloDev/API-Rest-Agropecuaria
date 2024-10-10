package br.camelodev.teste.posts;

import br.camelodev.teste.enums.tipo_cartao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CartaoCadastro(int id,
                             @NotBlank
                             String bandeira,
                             @NotBlank
                             String cvv,
                             int id_cliente,
                             @NotBlank
                             String nome,
                             @NotBlank
                             String numero,
                             boolean status_cartao,
                             tipo_cartao tipo_cartao,
                             @Future
                             LocalDate validade_cartao) {

}