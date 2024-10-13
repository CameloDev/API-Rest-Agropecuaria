package br.camelodev.teste.puts;

import br.camelodev.teste.enums.tipo_endereco;

public record AtualizarDadosEndereco(
        Long id,
        String estado,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        String complemento,
        tipo_endereco tipo_endereco,
        int id_cliente,
        int id_fornecedor,
        int id_vendedor,
        int id_funcionario
) {
}
