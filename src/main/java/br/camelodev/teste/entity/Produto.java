package br.camelodev.teste.entity;

import br.camelodev.teste.posts.ProdutoCadastro;
import br.camelodev.teste.puts.AtualizarDadosProduto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "produto")
@Entity(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
    public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private Float preco;
        private String marca;
        private String categoria;
        private String data_adicao;
        private Boolean status;
        private int quantidade;
        private String validade;
        private String data_fabricacao;
        private String codigo_barras;
        private Long id_fornecedor;
        private Long id_pedido;

        public Produto(ProdutoCadastro dadosCadastro) {
            this.id = (long) dadosCadastro.id();
            this.nome = dadosCadastro.nome();
            this.preco = dadosCadastro.preco();
            this.marca = dadosCadastro.marca();
            this.categoria = dadosCadastro.categoria();
            this.data_adicao = dadosCadastro.data_adicao();
            this.data_fabricacao = dadosCadastro.data_fabricacao();
            this.status = dadosCadastro.status();
            this.quantidade = dadosCadastro.quantidade();
            this.validade = dadosCadastro.validade();
            this.id_fornecedor = (long) dadosCadastro.id_fornecedor();
            this.id_pedido = (long) dadosCadastro.id_pedido();
        }

    public void atualizarInformacoesProduto(AtualizarDadosProduto dadosProduto) {
        if(dadosProduto.nome() != null){
            this.nome = dadosProduto.nome();
        }
        if(dadosProduto.preco() != null){
            this.preco = dadosProduto.preco();
        }
        if(dadosProduto.marca() != null){
            this.marca = dadosProduto.marca();
        }
        if(dadosProduto.categoria() != null){
            this.categoria = dadosProduto.categoria();
        }
        if(dadosProduto.data_adicao() != null){
            this.data_adicao = dadosProduto.data_adicao();
        }
        if(dadosProduto.status() != null){
            this.status = dadosProduto.status();
        }
        if(dadosProduto.quantidade() > 0){
            this.quantidade = dadosProduto.quantidade();
        }
        if(dadosProduto.validade() != null){
            this.validade = dadosProduto.validade();
        }
        if(dadosProduto.data_fabricacao() != null){
        this.data_fabricacao = dadosProduto.data_fabricacao();
        }
        if(dadosProduto.codigo_barras() != null){
            this.codigo_barras = dadosProduto.codigo_barras();
        }
        if(dadosProduto.id_fornecedor() > 0){
            this.id_fornecedor = (long) dadosProduto.id_fornecedor();
        }
        if(dadosProduto.id_pedido() > 0){
            this.id_pedido = (long) dadosProduto.id_pedido();
        }
    }
    public void inativar(){
        this.status = false;
    }
    public void ativar(){
        this.status = true;
    }
}


