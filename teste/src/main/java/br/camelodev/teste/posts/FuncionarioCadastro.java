package br.camelodev.teste.posts;

public record FuncionarioCadastro(int id,
                                  String cargo,
                                  String cpf,
                                  String data_nascimento,
                                  String departamento,
                                  String email,
                                  String estadocivil,
                                  int idade,
                                  String nome,
                                  String nomepai,
                                  String nomemae,
                                  float salario,
                                  String sexo) {
}
