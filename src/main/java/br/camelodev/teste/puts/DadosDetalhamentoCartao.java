package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Cartao;

public record DadosDetalhamentoCartao(int id,
                                      String bandeira,
                                      String cvv,
                                      int id_cliente,
                                      String nome,
                                      String numero,
                                      boolean status_cartao,
                                      br.camelodev.teste.enums.tipo_cartao tipo_cartao,
                                      String validadecartao) {
public DadosDetalhamentoCartao(Cartao cartao) {
        this(Math.toIntExact(cartao.getId()),
             cartao.getBandeira(),
             cartao.getCvv(),
             cartao.getId_cliente(),
             cartao.getNome(),
             cartao.getNumero(),
             cartao.isStatuscartao(),
             cartao.getTipo_cartao(),
                String.valueOf(cartao.getValidadecartao()));
    }
}