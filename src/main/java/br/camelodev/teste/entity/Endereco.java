package br.camelodev.teste.entity;

import br.camelodev.teste.posts.EnderecoCadastro;
import br.camelodev.teste.puts.AtualizarDadosEndereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "endereco")
@Entity(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String rua;
    private Long numero;
    private String complemento;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.tipo_endereco tipo_endereco;
    private String id_cliente;
    private String id_fornecedor;
    private String id_vendedor;
    private String id_funcionario;

    public Endereco(EnderecoCadastro dadosEndereco) {
        this.estado = dadosEndereco.estado();
        this.cidade = dadosEndereco.cidade();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.rua = dadosEndereco.rua();
        this.numero = (long) dadosEndereco.numero();
        this.complemento = dadosEndereco.Complemento();
        this.tipo_endereco = br.camelodev.teste.enums.tipo_endereco.valueOf(dadosEndereco.tipo_endereco());
        this.id_cliente = dadosEndereco.id_cliente();
        this.id_fornecedor = dadosEndereco.id_fornecedor();
        this.id_vendedor = dadosEndereco.id_vendedor();
        this.id_funcionario = dadosEndereco.id_funcionario();
    }

    public void atualizarInformacoesEndereco(@Valid AtualizarDadosEndereco dadosEndereco) {
        if(dadosEndereco.estado() != null){
            this.estado = dadosEndereco.estado();
        }
        if(dadosEndereco.cidade() != null){
            this.cidade = dadosEndereco.cidade();
        }
        if(dadosEndereco.bairro() != null){
            this.bairro = dadosEndereco.bairro();
        }
        if(dadosEndereco.cep() != null){
            this.cep = dadosEndereco.cep();
        }
        if(dadosEndereco.rua() != null){
            this.rua = dadosEndereco.rua();
        }
        if(dadosEndereco.numero() > 0){
            this.numero = (long) dadosEndereco.numero();
        }
        if(dadosEndereco.complemento() != null){
            this.complemento = dadosEndereco.complemento();
        }
        if(dadosEndereco.tipo_endereco() != null){
            this.tipo_endereco = dadosEndereco.tipo_endereco();
        }

    }
}