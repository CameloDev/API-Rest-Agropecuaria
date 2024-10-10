package br.camelodev.teste.repository;

import br.camelodev.teste.entity.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<produto, Integer> {
}
