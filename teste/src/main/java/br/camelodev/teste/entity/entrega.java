package br.camelodev.teste.entity;

import br.camelodev.teste.posts.EntregaCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "entrega")
@Entity(name = "entregas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.status_entrega status_entrega;
    private int id_endereco;
    private int id_fornecedor;
    private String data_envio;
    private Float taxa_entrega;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.metodo_envio metodo_envio;
    private String observacao;

    public entrega(EntregaCadastro dadosEntrega) {
        this.id = dadosEntrega.id();
        this.status_entrega = br.camelodev.teste.enums.status_entrega.valueOf(dadosEntrega.status_entrega());
        this.id_endereco = dadosEntrega.id_endereco();
        this.id_fornecedor = dadosEntrega.id_fornecedor();
        this.data_envio = dadosEntrega.data_envio();
        this.taxa_entrega = dadosEntrega.taxa_entrega();
        this.observacao = dadosEntrega.observacao();
        this.metodo_envio = br.camelodev.teste.enums.metodo_envio.valueOf(dadosEntrega.metodo_envio());
    }
}
