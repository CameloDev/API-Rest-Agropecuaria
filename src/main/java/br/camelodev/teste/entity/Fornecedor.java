package br.camelodev.teste.entity;

import br.camelodev.teste.posts.FornecedorCadastro;
import br.camelodev.teste.puts.AtualizarDadosFornecedor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "fornecedor")
@Entity(name = "fornecedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private Boolean status;
    private String data_registro;
    private String departamento;
    private String condicoes_pagamento;

    public Fornecedor(FornecedorCadastro dadosFornecedor) {
        this.id = (long) dadosFornecedor.id();
        this.nome = dadosFornecedor.nome();
        this.cnpj = dadosFornecedor.cnpj();
        this.condicoes_pagamento = dadosFornecedor.condicoes_de_pagamento();
        this.data_registro = dadosFornecedor.data_registro();
        this.departamento = dadosFornecedor.departamento();
        this.email = dadosFornecedor.email();
        this.nome = dadosFornecedor.nome();
        this.status = dadosFornecedor.status();
    }

    public void atualizarInformacoesFornecedor(@Valid AtualizarDadosFornecedor dadosFornecedor) {
        if(dadosFornecedor.nome() != null){
            this.nome = dadosFornecedor.nome();
        }
        if(dadosFornecedor.cnpj() != null) {
            this.cnpj = dadosFornecedor.cnpj();
        }
        if(dadosFornecedor.condicoes_de_pagamento() != null) {
            this.condicoes_pagamento = dadosFornecedor.condicoes_de_pagamento();
        }
        if(dadosFornecedor.data_registro() != null) {
            this.data_registro = dadosFornecedor.data_registro();
        }
        if(dadosFornecedor.departamento() != null) {
            this.departamento = dadosFornecedor.departamento();
        }
        if(dadosFornecedor.email() != null){
            this.email = dadosFornecedor.email();
        }
        if(dadosFornecedor.nome() != null) {
            this.nome = dadosFornecedor.nome();
        }
    }
    public void inativar(){
        this.status = false;
    }
    public void ativar(){
        this.status = true;
    }
}
