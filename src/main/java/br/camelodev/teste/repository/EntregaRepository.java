package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository <Entrega, Integer> {
}
