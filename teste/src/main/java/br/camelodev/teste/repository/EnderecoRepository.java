package br.camelodev.teste.repository;

import br.camelodev.teste.entity.endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<endereco, Integer> {
}
