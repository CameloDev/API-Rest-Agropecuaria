package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Funcionario;

public record FuncionarioDados(int id,
                               String cpf,
                               String departamento,
                               String email,
                               String nome) {
    public FuncionarioDados(Funcionario funcionario) {
        this(Math.toIntExact(funcionario.getId()),
                funcionario.getCpf(),
                funcionario.getDepartamento(),
                funcionario.getEmail(),
                funcionario.getNome());
    }
}
