package br.camelodev.teste.repository;

import br.camelodev.teste.entity.vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<vendedor, Integer> {
}
