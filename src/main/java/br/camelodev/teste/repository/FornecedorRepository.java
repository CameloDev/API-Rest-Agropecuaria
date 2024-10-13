package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Cliente;
import br.camelodev.teste.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findAllByStatusTrue();
}
