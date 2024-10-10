package br.camelodev.teste.posts;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

public record ClienteCadastro(
            int id,
            @NotBlank
            String nome,
            @NotBlank
            String cpf,
            @Past
            LocalDate data_nascimento,
            int idade,
            @PastOrPresent
            LocalDate data_cadastro,
            @NotBlank
            String sexo,
            @NotBlank
            String estadocivil,
            @NotBlank
            String nomemae,
            @NotBlank
            String nomepai,
            boolean status_devedor,
            @NotBlank
            String email) {

}