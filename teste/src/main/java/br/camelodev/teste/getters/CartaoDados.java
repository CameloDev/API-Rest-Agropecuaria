package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Cartao;
import br.camelodev.teste.enums.tipo_cartao;
public record CartaoDados(
        String numero,
        String cvv,
        String nome,
        String validade_cartao,
        String bandeira,
        tipo_cartao tipo_cartao
        ) {
    public CartaoDados(Cartao cartao) {
        this(cartao.getNumero(), cartao.getCvv(),cartao.getNome(), String.valueOf(cartao.getValidadecartao()),cartao.getBandeira(),cartao.getTipo_cartao());
    }
}
