package br.camelodev.teste.entity;

import br.camelodev.teste.enums.sexo;
import br.camelodev.teste.posts.FuncionarioCadastro;
import br.camelodev.teste.puts.AtualizarDadosFuncionario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "funcionario")
@Entity(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Funcionario(FuncionarioCadastro dadosfuncionario) {
        this.id = (long) dadosfuncionario.id();
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

    public void atualizarInformacoesFuncionario(@Valid AtualizarDadosFuncionario dadosFuncionario) {
        if (dadosFuncionario.nome() != null) {
            this.nome = dadosFuncionario.nome();
        }
        if (dadosFuncionario.cpf() != null) {
            this.cpf = dadosFuncionario.cpf();
        }
        if (dadosFuncionario.data_nascimento() != null) {
            this.data_nascimento = dadosFuncionario.data_nascimento();
        }
        if (dadosFuncionario.sexo() != null) {
            this.sexo = br.camelodev.teste.enums.sexo.valueOf(dadosFuncionario.sexo());
        }
        if (dadosFuncionario.idade() > 0) {
            this.idade = dadosFuncionario.idade();
        }
        if (dadosFuncionario.departamento() != null) {
            this.departamento = dadosFuncionario.departamento();
        }
        if (dadosFuncionario.cargo() != null) {
            this.cargo = dadosFuncionario.cargo();
        }
        if (dadosFuncionario.nomemae() != null) {
            this.nomemae = dadosFuncionario.nomemae();
        }
        if (dadosFuncionario.nomepai() != null) {
            this.nome_pai = dadosFuncionario.nomepai();
        }
        if (dadosFuncionario.email() != null) {
            this.email = dadosFuncionario.email();
        }
        if (dadosFuncionario.salario() > 0) {
            this.salario = dadosFuncionario.salario();
        }
    }
}
