package br.camelodev.teste.repository;

import br.camelodev.teste.entity.entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository <entrega, Integer> {
}
