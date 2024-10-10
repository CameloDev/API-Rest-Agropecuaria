package br.camelodev.teste.repository;


import br.camelodev.teste.entity.funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<funcionario, Integer> {
}
