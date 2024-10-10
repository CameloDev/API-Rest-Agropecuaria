package br.camelodev.teste.entity;

import br.camelodev.teste.posts.VendedorCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "vendedor")
@Entity(name = "vendedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo_vendedor;
    private int quantidade_vendas;
    private Float comissao_vendas;
    private String cargo;
    private String data_contratacao;
    private int meta_vendas;
    private Boolean status;
    private int id_funcionario;

    public vendedor(VendedorCadastro dadosVendedor) {
        this.id = dadosVendedor.id();
        this.codigo_vendedor = dadosVendedor.codigo_vendedor();
        this.quantidade_vendas = dadosVendedor.quantidade_vendas();
        this.comissao_vendas = dadosVendedor.comissao_vendas();
        this.cargo = dadosVendedor.cargo();
        this.data_contratacao = dadosVendedor.data_contratacao();
        this.meta_vendas = dadosVendedor.meta_vendas();
        this.status = dadosVendedor.status();
        this.id_funcionario = dadosVendedor.id_funcionario();
    }
}
