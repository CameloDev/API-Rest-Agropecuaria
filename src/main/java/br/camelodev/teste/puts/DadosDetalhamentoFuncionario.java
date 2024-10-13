package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Funcionario;

public record DadosDetalhamentoFuncionario(int id,
                                           String cargo,
                                           String cpf,
                                           String data_nascimento,
                                           String departamento,
                                           String email,
                                           br.camelodev.teste.enums.estadocivil estadocivil,
                                           int idade,
                                           String nome,
                                           String nomepai,
                                           String nomemae,
                                           float salario,
                                           br.camelodev.teste.enums.sexo sexo) {
    public DadosDetalhamentoFuncionario(Funcionario funcionario) {
        this(Math.toIntExact(funcionario.getId()),
                funcionario.getCargo(),
                funcionario.getCpf(),
                funcionario.getData_nascimento(),
                funcionario.getDepartamento(),
                funcionario.getEmail(),
                funcionario.getEstadocivil(),
                funcionario.getIdade(),
                funcionario.getNome(),
                funcionario.getNome_pai(),
                funcionario.getNomemae(),
                funcionario.getSalario(),
                funcionario.getSexo());
    }
}
