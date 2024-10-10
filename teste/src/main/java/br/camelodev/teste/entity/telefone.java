package br.camelodev.teste.entity;

import br.camelodev.teste.posts.TelefoneCadastro;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "telefone")
@Entity(name = "telefones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String telefone;
    private int id_cliente;
    private int id_vendedor;
    private int id_fornecedor;
    private int id_funcionario;

    public telefone(TelefoneCadastro dadosTelefone) {
        this.id = dadosTelefone.id();
        this.telefone = dadosTelefone.telefone();
        this.id_cliente = dadosTelefone.id_cliente();
        this.id_vendedor = dadosTelefone.id_vendedor();
        this.id_fornecedor = dadosTelefone.id_fornecedor();
        this.id_funcionario = dadosTelefone.id_funcionario();
    }
}

