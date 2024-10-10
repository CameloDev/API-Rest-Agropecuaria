package br.camelodev.teste.repository;

import br.camelodev.teste.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository <Cartao, Long> {
    List<Cartao> findAllByStatuscartaoTrue();
}
