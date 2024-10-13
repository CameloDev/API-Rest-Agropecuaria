package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Telefone;

public record TelefoneDados(int id,
                            String telefone) {
    public TelefoneDados(Telefone telefone) {
        this(Math.toIntExact(telefone.getId()),
             telefone.getTelefone());
    }
}
