package br.camelodev.teste.puts;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record AtualizarDadosCliente(
        Long id,
        String nome,
         String cpf,
        LocalDate data_nascimento,
        LocalDate data_cadastro,
        String sexo,
        String estadocivil,
        String nomemae,
        String nomepai,
        boolean status_devedor,
        String email

) {
}
