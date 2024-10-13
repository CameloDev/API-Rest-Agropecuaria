package br.camelodev.teste.controller;

import br.camelodev.teste.getters.ClienteDados;
import br.camelodev.teste.posts.ClienteCadastro;
import br.camelodev.teste.entity.Cliente;
import br.camelodev.teste.puts.AtualizarDadosCliente;
import br.camelodev.teste.puts.DadosDetalhamentoCliente;
import br.camelodev.teste.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ControllerCliente {

    @Autowired
    private ClienteRepository Clienterepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCliente> cadastrarCliente(@RequestBody @Valid ClienteCadastro dadosCliente, UriComponentsBuilder uriBuilder1) {
        var cliente = new Cliente(dadosCliente);
        Clienterepository.save(cliente);
        var uri = uriBuilder1.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDados>> listarClientes() {
        var lista =  Clienterepository.findAllByStatusDevedorTrue().stream().map(ClienteDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCliente> atualizarCliente(@RequestBody @Valid AtualizarDadosCliente dadosCliente) {
        var cliente = Clienterepository.getReferenceById(dadosCliente.id());
        cliente.atualizarInformacoesCliente(dadosCliente);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        Clienterepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarCliente(@PathVariable Long id) {
        var cliente = Clienterepository.getReferenceById(id);
        cliente.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarCliente(@PathVariable Long id) {
        var cliente = Clienterepository.getReferenceById(id);
        cliente.setStatusDevedor();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCliente> detalharCliente(@PathVariable Long id) {
        var cliente = Clienterepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}