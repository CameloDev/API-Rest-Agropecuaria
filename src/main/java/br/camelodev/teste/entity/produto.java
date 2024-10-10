package br.camelodev.teste.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "produto")
@Entity(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
    public class
    produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
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
        private int id_fornecedor;
        private int id_pedido;
    }


