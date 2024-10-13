package br.camelodev.teste.getters;
import br.camelodev.teste.entity.Endereco;
import br.camelodev.teste.entity.Entrega;
import br.camelodev.teste.enums.status_entrega;
import br.camelodev.teste.enums.metodo_envio;
import org.w3c.dom.Text;

public record EntregaDados(int id,
                           String status_entrega,
                           String data_envio,
                           Float taxa_entrega,
                           metodo_envio metodo_envio,
                           String observacao) {
    public EntregaDados(Entrega entrega) {
        this(Math.toIntExact(entrega.getId()),
             String.valueOf(entrega.getStatus_entrega()),
             entrega.getData_envio(),
             entrega.getTaxa_entrega(),
             entrega.getMetodo_envio(),
             entrega.getObservacao());
    }
}
