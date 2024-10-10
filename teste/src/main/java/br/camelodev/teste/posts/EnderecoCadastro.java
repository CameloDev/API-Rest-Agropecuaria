package br.camelodev.teste.posts;
public record EnderecoCadastro(int id,
                               String bairro,
                               String Complemento,
                               String cep,
                               String cidade,
                               String estado,
                               String id_cliente,
                               String id_fornecedor,
                               String id_funcionario,
                               String id_vendedor,
                               int numero,
                               String rua,
                               String tipo_endereco) {
}
