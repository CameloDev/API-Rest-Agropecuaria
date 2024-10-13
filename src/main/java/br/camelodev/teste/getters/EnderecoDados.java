package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Endereco;

public record EnderecoDados(int id,
                            String rua,
                            String numero,
                            String bairro,
                            String cidade,
                            String estado,
                            String cep) {
    public EnderecoDados(Endereco endereco) {
        this(Math.toIntExact(endereco.getId()),
             endereco.getRua(),
             String.valueOf(endereco.getNumero()),
             endereco.getBairro(),
             endereco.getCidade(),
             endereco.getEstado(),
             endereco.getCep());
    }
}
