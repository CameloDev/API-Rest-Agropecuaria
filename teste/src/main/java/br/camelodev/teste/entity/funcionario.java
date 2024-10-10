package br.camelodev.teste.entity;

import br.camelodev.teste.posts.FuncionarioCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "funcionario")
@Entity(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private String data_nascimento;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.sexo sexo;
    private int idade;
    private String departamento;
    private String cargo;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.estadocivil estadocivil;
    private String nomemae;
    private String nome_pai;
    private String email;
    private Float salario;

    public funcionario(FuncionarioCadastro dadosfuncionario) {
        this.id = dadosfuncionario.id();
        this.nome = dadosfuncionario.nome();
        this.cpf = dadosfuncionario.cpf();
        this.data_nascimento = dadosfuncionario.data_nascimento();
        this.sexo = br.camelodev.teste.enums.sexo.valueOf(dadosfuncionario.sexo());
        this.idade = dadosfuncionario.idade();
        this.departamento = dadosfuncionario.departamento();
        this.cargo = dadosfuncionario.cargo();
        this.nomemae = dadosfuncionario.nomemae();
        this.nome_pai = dadosfuncionario.nomepai();
        this.email = dadosfuncionario.email();
        this.salario = dadosfuncionario.salario();
    }
}
