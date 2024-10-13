package br.camelodev.teste.entity;

import br.camelodev.teste.posts.EntregaCadastro;
import br.camelodev.teste.puts.AtualizarDadosEntrega;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "entrega")
@Entity(name = "entregas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.status_entrega status_entrega;
    private Long id_endereco;
    private Long id_fornecedor;
    private String data_envio;
    private Float taxa_entrega;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.metodo_envio metodo_envio;
    private String observacao;

    public Entrega(EntregaCadastro dadosEntrega) {
        this.id = (long) dadosEntrega.id();
        this.status_entrega = br.camelodev.teste.enums.status_entrega.valueOf(dadosEntrega.status_entrega());
        this.id_endereco = (long) dadosEntrega.id_endereco();
        this.id_fornecedor = (long) dadosEntrega.id_fornecedor();
        this.data_envio = dadosEntrega.data_envio();
        this.taxa_entrega = dadosEntrega.taxa_entrega();
        this.observacao = dadosEntrega.observacao();
        this.metodo_envio = br.camelodev.teste.enums.metodo_envio.valueOf(dadosEntrega.metodo_envio());
    }

    public void atualizarInformacoesEntrega(@Valid AtualizarDadosEntrega dadosEntrega) {
        if(dadosEntrega.status_entrega() != null){
            this.status_entrega = br.camelodev.teste.enums.status_entrega.valueOf(dadosEntrega.status_entrega());
        }
        if(dadosEntrega.id_endereco() > 0){
            this.id_endereco = (long) dadosEntrega.id_endereco();
        }
        if(dadosEntrega.id_fornecedor() > 0){
            this.id_fornecedor = (long) dadosEntrega.id_fornecedor();
        }
        if(dadosEntrega.data_envio() != null){
            this.data_envio = dadosEntrega.data_envio();
        }
        if(dadosEntrega.observacao() != null){
            this.observacao = dadosEntrega.observacao();
        }
        if(dadosEntrega.metodo_envio() != null){
            this.metodo_envio = br.camelodev.teste.enums.metodo_envio.valueOf(dadosEntrega.metodo_envio());
        }
    }
}
