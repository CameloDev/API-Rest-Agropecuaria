package br.camelodev.teste.puts;

import br.camelodev.teste.entity.Cliente;

import java.time.LocalDate;

public record DadosDetalhamentoCliente(Long id,
                                       String nome,
                                       String cpf,
                                       LocalDate data_nascimento,
                                       int idade,
                                       LocalDate data_cadastro,
                                       br.camelodev.teste.enums.sexo sexo,
                                       br.camelodev.teste.enums.estadocivil estadocivil,
                                       String nomemae,
                                       String nomepai,
                                       boolean status_devedor,
                                       String email) {
   public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(),
             cliente.getNome(),
             cliente.getCpf(),
             cliente.getDataNascimento(),
             cliente.getIdade(),
             cliente.getDataCadastro(),
             cliente.getSexo(),
             cliente.getEstadocivil(),
             cliente.getNomemae(),
             cliente.getNomepai(),
             cliente.isStatusDevedor(),
             cliente.getEmail());
    }
}
