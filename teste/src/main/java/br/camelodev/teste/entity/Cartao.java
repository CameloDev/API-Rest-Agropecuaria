package br.camelodev.teste.entity;
import br.camelodev.teste.posts.CartaoCadastro;
import br.camelodev.teste.puts.AtualizarDadosCartao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Cartao")
@Entity(name = "Cartoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String cvv;
    private String nome;
    private LocalDate validadecartao;
    private String bandeira;
    private boolean statuscartao;
    @Enumerated(EnumType.STRING)
    private br.camelodev.teste.enums.tipo_cartao tipo_cartao;
    private int id_cliente;

    public Cartao(CartaoCadastro dados) {
    this.numero = dados.numero();
    this.cvv = dados.cvv();
    this.nome = dados.nome();
    this.validadecartao = dados.validade_cartao();
    this.bandeira = dados.bandeira();
    this.statuscartao = dados.status_cartao();
    this.tipo_cartao = dados.tipo_cartao();
    this.id_cliente = dados.id_cliente();
    }

    public void atualizarInformacoesCartao(@Valid AtualizarDadosCartao dadosCartao) {
        if(dadosCartao.numero() != null){
            this.numero = dadosCartao.numero();
        }
        if(dadosCartao.cvv() != null){
            this.cvv = dadosCartao.cvv();
        }
        if(dadosCartao.nome() != null){
            this.nome = dadosCartao.nome();
        }
        if(dadosCartao.validade_cartao() != null){
            this.validadecartao = LocalDate.parse(dadosCartao.validade_cartao());
        }
        if(dadosCartao.bandeira() != null){
            this.bandeira = dadosCartao.bandeira();
        }
        if(dadosCartao.tipo_cartao() != null){
            this.tipo_cartao = dadosCartao.tipo_cartao();
        }
    }

    public void inativar() {
        this.statuscartao = false;
    }
    public void ativar(){
        this.statuscartao = true;
    }
}
