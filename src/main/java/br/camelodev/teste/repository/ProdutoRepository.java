package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findAllByStatusTrue();
}
