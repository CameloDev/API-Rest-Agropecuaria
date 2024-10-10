package br.camelodev.teste.repository;

import br.camelodev.teste.entity.fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<fornecedor, Integer> {
}
