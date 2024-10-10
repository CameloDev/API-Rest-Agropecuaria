package br.camelodev.teste.repository;

import br.camelodev.teste.entity.pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<pedido, Integer> {
}
