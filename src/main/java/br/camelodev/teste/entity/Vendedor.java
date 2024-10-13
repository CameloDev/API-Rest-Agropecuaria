package br.camelodev.teste.entity;

import br.camelodev.teste.posts.VendedorCadastro;
import br.camelodev.teste.puts.AtualizarDadosVendedor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "vendedor")
@Entity(name = "vendedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo_vendedor;
    private int quantidade_vendas;
    private Float comissao_vendas;
    private String cargo;
    private String data_contratacao;
    private int meta_vendas;
    private Boolean status;
    private Long id_funcionario;

    public Vendedor(VendedorCadastro dadosVendedor) {
        this.id = (long) dadosVendedor.id();
        this.codigo_vendedor = dadosVendedor.codigo_vendedor();
        this.quantidade_vendas = dadosVendedor.quantidade_vendas();
        this.comissao_vendas = dadosVendedor.comissao_vendas();
        this.cargo = dadosVendedor.cargo();
        this.data_contratacao = dadosVendedor.data_contratacao();
        this.meta_vendas = dadosVendedor.meta_vendas();
        this.status = dadosVendedor.status();
        this.id_funcionario = (long) dadosVendedor.id_funcionario();
    }

    public void atualizarInformacoesVendedor(@Valid AtualizarDadosVendedor dadosVendedor) {
        if (dadosVendedor.codigo_vendedor() != null) {
            this.codigo_vendedor = dadosVendedor.codigo_vendedor();
        }
        if (dadosVendedor.quantidade_vendas() > 0) {
            this.quantidade_vendas = dadosVendedor.quantidade_vendas();
        }
        if (dadosVendedor.comissao_vendas() > 0) {
            this.comissao_vendas = dadosVendedor.comissao_vendas();
        }
        if (dadosVendedor.cargo() != null) {
            this.cargo = dadosVendedor.cargo();
        }
        if (dadosVendedor.data_contratacao() != null) {
            this.data_contratacao = dadosVendedor.data_contratacao();
        }
        if (dadosVendedor.meta_vendas() > 0) {
            this.meta_vendas = dadosVendedor.meta_vendas();
        }
        if (dadosVendedor.id_funcionario() > 0) {
            this.id_funcionario = (long) dadosVendedor.id_funcionario();
        }

    }
    public void inativar(){
        this.status = false;
    }
    public void ativar(){
        this.status = true;
    }
}
