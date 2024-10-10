
package br.camelodev.teste.entity;
import br.camelodev.teste.posts.PedidoCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "pedido")
@Entity(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantidade_produtos;
    private int preco_total;
    private String datapedido;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.tipo_pagamento tipo_pagamento;
    private Float taxa_entrega;
    private int id_entrega;
    private int id_cliente;
    private int id_vendedor;

    public pedido(PedidoCadastro dadosPedido) {
        this.id = dadosPedido.id();
        this.quantidade_produtos = dadosPedido.quantidade_produtos();
        this.preco_total = dadosPedido.preco_total();
        this.datapedido = dadosPedido.datapedido();
        this.tipo_pagamento = br.camelodev.teste.enums.tipo_pagamento.valueOf(dadosPedido.tipo_pagamento());
        this.id_entrega = dadosPedido.id_entrega();
        this.taxa_entrega = dadosPedido.taxa_entrega();
        this.id_vendedor = dadosPedido.id_vendedor();
    }
}
