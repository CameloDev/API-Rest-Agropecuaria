package br.camelodev.teste.getters;

import br.camelodev.teste.entity.Cliente;

public record ClienteDados(Long id,
                           String nome,
                           String cpf) {
    public ClienteDados(Cliente cliente){
        this(cliente.getId(),
             cliente.getNome(),
             cliente.getCpf());
    }
}
