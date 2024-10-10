package br.camelodev.teste.controller;

import br.camelodev.teste.entity.pedido;
import br.camelodev.teste.posts.PedidoCadastro;
import br.camelodev.teste.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class ControllerPedido {

    @Autowired
    private PedidoRepository Pedido;
    @PostMapping
    public void cadastrarPedido(@RequestBody PedidoCadastro dadosPedido) {
        Pedido.save(new pedido(dadosPedido));
    }
}