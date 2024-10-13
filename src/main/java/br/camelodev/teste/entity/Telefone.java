package br.camelodev.teste.entity;

import br.camelodev.teste.posts.TelefoneCadastro;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import br.camelodev.teste.puts.AtualizarDadosTelefone;

@Table(name = "telefone")
@Entity(name = "telefones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String id_cliente;
    private String id_fornecedor;
    private String id_vendedor;
    private String id_funcionario;

    public Telefone(TelefoneCadastro dadosTelefone) {
        this.id = (long) dadosTelefone.id();
        this.telefone = dadosTelefone.telefone();
        this.id_cliente = dadosTelefone.id_cliente();
        this.id_vendedor = dadosTelefone.id_vendedor();
        this.id_fornecedor = dadosTelefone.id_fornecedor();
        this.id_funcionario = dadosTelefone.id_funcionario();
    }

    public void atualizarInformacoesTelefone(@Valid AtualizarDadosTelefone dadosTelefone) {
        if (dadosTelefone.telefone() != null) {
            this.telefone = dadosTelefone.telefone();
        }
        if (dadosTelefone.id_cliente() > 0) {
            this.id_cliente = String.valueOf(dadosTelefone.id_cliente());
        }
        if (dadosTelefone.id_vendedor() > 0) {
            this.id_vendedor = String.valueOf(dadosTelefone.id_vendedor());
        }
        if (dadosTelefone.id_fornecedor() > 0) {
            this.id_fornecedor = String.valueOf(dadosTelefone.id_fornecedor());
        }
        if (dadosTelefone.id_funcionario() > 0) {
            this.id_funcionario = String.valueOf(dadosTelefone.id_funcionario());
        }
    }

}

