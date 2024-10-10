package br.camelodev.teste.entity;

import br.camelodev.teste.posts.EnderecoCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "endereco")
@Entity(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String rua;
    private int numero;
    private String complemento;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.tipo_endereco tipo_endereco;
    private String id_cliente;
    private String id_fornecedor;
    private String id_vendedor;
    private String id_funcionario;

    public endereco(EnderecoCadastro dadosEndereco) {
        this.id = dadosEndereco.id();
        this.estado = dadosEndereco.estado();
        this.cidade = dadosEndereco.cidade();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.rua = dadosEndereco.rua();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.Complemento();
        this.tipo_endereco = br.camelodev.teste.enums.tipo_endereco.valueOf(dadosEndereco.tipo_endereco());
        this.id_cliente = dadosEndereco.id_cliente();
        this.id_fornecedor = dadosEndereco.id_fornecedor();
        this.id_vendedor = dadosEndereco.id_vendedor();
        this.id_funcionario = dadosEndereco.id_funcionario();
    }
}