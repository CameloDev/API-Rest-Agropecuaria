package br.camelodev.teste.entity;
import br.camelodev.teste.posts.ClienteCadastro;
import br.camelodev.teste.puts.AtualizarDadosCliente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Cliente")
@Entity(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private int idade;
    private LocalDate dataCadastro;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.sexo sexo;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.estadocivil estadocivil;
    private String nomemae;
    private String nomepai;
    private boolean statusDevedor;
    private String email;

    public Cliente(ClienteCadastro dadosCliente) {
        this.nome = dadosCliente.nome();
        this.cpf = dadosCliente.cpf();
        this.dataNascimento = dadosCliente.data_nascimento();
        this.dataCadastro = dadosCliente.data_cadastro();
        this.sexo = br.camelodev.teste.enums.sexo.valueOf(dadosCliente.sexo());
        this.estadocivil = br.camelodev.teste.enums.estadocivil.valueOf(dadosCliente.estadocivil());
        this.nomepai = dadosCliente.nomepai();
        this.nomemae = dadosCliente.nomemae();
        this.statusDevedor = dadosCliente.status_devedor();
        this.email = dadosCliente.email();
    }

    public void atualizarInformacoesCliente(@Valid AtualizarDadosCliente dadosCliente) {
        if(dadosCliente.nome() != null) {
            this.nome = dadosCliente.nome();
        }
        if(dadosCliente.cpf() != null) {
            this.cpf = dadosCliente.cpf();
        }
        if(dadosCliente.data_nascimento() != null) {
            this.dataNascimento = dadosCliente.data_nascimento();
        }
        if(dadosCliente.data_cadastro() != null) {
            this.dataCadastro = dadosCliente.data_cadastro();
        }
        if(dadosCliente.sexo() != null) {
            this.sexo = br.camelodev.teste.enums.sexo.valueOf(dadosCliente.sexo());
        }
        if(dadosCliente.estadocivil() != null) {
            this.estadocivil = br.camelodev.teste.enums.estadocivil.valueOf(dadosCliente.estadocivil());
        }
        if(dadosCliente.nomepai() != null) {
            this.nomepai = dadosCliente.nomepai();
        }
        if(dadosCliente.nomemae() != null) {
            this.nomemae = dadosCliente.nomemae();
        }
        if(dadosCliente.email() != null){
            this.email = dadosCliente.email();
        }
    }

    public void inativar() {
        this.statusDevedor = false;
    }

    public void setStatusDevedor() {
        this.statusDevedor = true;
    }
}
