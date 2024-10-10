package br.camelodev.teste.repository;

import br.camelodev.teste.entity.telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<telefone, Integer> {
}
