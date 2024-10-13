package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Pedido;
import br.camelodev.teste.getters.PedidoDados;
import br.camelodev.teste.posts.PedidoCadastro;
import br.camelodev.teste.puts.AtualizarDadosPedido;
import br.camelodev.teste.puts.DadosDetalhamentoPedido;
import br.camelodev.teste.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class ControllerPedido {

    @Autowired
    private PedidoRepository Pedidorepo;
    @PostMapping
    public ResponseEntity<DadosDetalhamentoPedido> cadastrarPedido(@RequestBody @Valid PedidoCadastro dadosPedido, UriComponentsBuilder uriF) {
        var pedido = new Pedido(dadosPedido);
        Pedidorepo.save(new Pedido(dadosPedido));
        var uri = uriF.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPedido(pedido));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDados>> listarPedido() {
        var lista =  Pedidorepo.findAll().stream().map(PedidoDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPedido> atualizarPedido(@RequestBody @Valid AtualizarDadosPedido dadosPedido) {
        var pedido = Pedidorepo.getReferenceById(dadosPedido.id());
        pedido.atualizarInformacoesPedido(dadosPedido);
        return ResponseEntity.ok(new DadosDetalhamentoPedido(pedido));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        Pedidorepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPedido> detalharPedido(@PathVariable Long id) {
        var pedido = Pedidorepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoPedido(pedido));
    }
}