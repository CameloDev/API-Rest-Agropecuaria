
package br.camelodev.teste.entity;
import br.camelodev.teste.enums.tipo_pagamento;
import br.camelodev.teste.posts.PedidoCadastro;
import br.camelodev.teste.puts.AtualizarDadosPedido;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "pedido")
@Entity(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade_produtos;
    private int preco_total;
    private String datapedido;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.tipo_pagamento tipo_pagamento;
    private Float taxa_entrega;
    private int id_entrega;
    private int id_cliente;
    private int id_vendedor;

    public Pedido(PedidoCadastro dadosPedido) {
        this.id = (long) dadosPedido.id();
        this.quantidade_produtos = dadosPedido.quantidade_produtos();
        this.preco_total = dadosPedido.preco_total();
        this.datapedido = dadosPedido.datapedido();
        this.tipo_pagamento = br.camelodev.teste.enums.tipo_pagamento.valueOf(dadosPedido.tipo_pagamento());
        this.id_entrega = dadosPedido.id_entrega();
        this.id_cliente = dadosPedido.id_cliente();
        this.taxa_entrega = dadosPedido.taxa_entrega();
        this.id_vendedor = dadosPedido.id_vendedor();
    }

    public void atualizarInformacoesPedido(@Valid AtualizarDadosPedido dadosPedido) {
        if (dadosPedido.quantidade_produtos() > 0) {
            this.quantidade_produtos = dadosPedido.quantidade_produtos();
        }
        if (dadosPedido.preco_total() > 0) {
            this.preco_total = dadosPedido.preco_total();
        }
        if (dadosPedido.datapedido() != null) {
            this.datapedido = dadosPedido.datapedido();
        }
        if (dadosPedido.tipo_pagamento() != null) {
            this.tipo_pagamento = br.camelodev.teste.enums.tipo_pagamento.valueOf(dadosPedido.tipo_pagamento());
        }
        if (dadosPedido.id_entrega() > 0) {
            this.id_entrega = dadosPedido.id_entrega();
        }
        if (dadosPedido.id_cliente() > 0) {
            this.id_cliente = dadosPedido.id_cliente();
        }
        if (dadosPedido.id_vendedor() > 0) {
            this.id_vendedor = dadosPedido.id_vendedor();
        }
    }
}
