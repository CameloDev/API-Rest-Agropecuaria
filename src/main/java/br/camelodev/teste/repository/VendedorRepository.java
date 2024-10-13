package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    List<Vendedor> findAllByStatusTrue();
}
