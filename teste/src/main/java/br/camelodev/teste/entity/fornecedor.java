package br.camelodev.teste.entity;

import br.camelodev.teste.posts.FornecedorCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "fornecedor")
@Entity(name = "fornecedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private Boolean status;
    private String data_registro;
    private String condicoes_pagamento;

    public fornecedor(FornecedorCadastro dadosFornecedor) {
        this.id = dadosFornecedor.id();
        this.cnpj = dadosFornecedor.cnpj();
        this.condicoes_pagamento = dadosFornecedor.condicoes_de_pagamento();
        this.data_registro = dadosFornecedor.data_registro();
        this.email = dadosFornecedor.email();
        this.nome = dadosFornecedor.nome();
        this.status = dadosFornecedor.status();
    }
}
