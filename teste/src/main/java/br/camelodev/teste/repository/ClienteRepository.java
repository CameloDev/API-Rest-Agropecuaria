package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByStatusDevedorTrue();
}
