package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Endereco;

public record DadosDetalhamentoEndereco(
        int id,
        String estado,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        String complemento,
        br.camelodev.teste.enums.tipo_endereco tipo_endereco,
        String id_cliente,
        String id_fornecedor,
        String id_vendedor,
        String id_funcionario
) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this(Math.toIntExact(endereco.getId()),endereco.getEstado(), endereco.getCidade(),endereco.getBairro(), endereco.getCep(), endereco.getRua(), Math.toIntExact(endereco.getNumero()),endereco.getComplemento(),endereco.getTipo_endereco(),endereco.getId_cliente(),endereco.getId_fornecedor(),endereco.getId_vendedor(),endereco.getId_funcionario());
    }
}
