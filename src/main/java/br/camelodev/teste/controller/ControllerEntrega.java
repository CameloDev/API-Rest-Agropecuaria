package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Entrega;
import br.camelodev.teste.getters.EntregaDados;
import br.camelodev.teste.posts.EntregaCadastro;
import br.camelodev.teste.puts.AtualizarDadosEntrega;
import br.camelodev.teste.puts.DadosDetalhamentoEntrega;
import br.camelodev.teste.repository.EntregaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/entrega")
public class ControllerEntrega {

    @Autowired
    private EntregaRepository Entregarepo;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoEntrega> cadastrarEntrega(@RequestBody @Valid EntregaCadastro dadosEntrega, UriComponentsBuilder uriE) {
        var entrega = new Entrega(dadosEntrega);
        Entregarepo.save(new Entrega(dadosEntrega));
        var uri = uriE.path("/entrega/{id}").buildAndExpand(entrega.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEntrega(entrega));
    }

    @GetMapping
    public ResponseEntity<List<EntregaDados>> listarEntrega() {
        var lista =  Entregarepo.findAll().stream().map(EntregaDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEntrega> atualizarEntrega(@RequestBody @Valid AtualizarDadosEntrega dadosEntrega) {
        var entrega= Entregarepo.getReferenceById(Math.toIntExact(dadosEntrega.id()));
        entrega.atualizarInformacoesEntrega(dadosEntrega);
        return ResponseEntity.ok(new DadosDetalhamentoEntrega(entrega));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirEntrega(@PathVariable Long id) {
        Entregarepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEntrega> detalharEntrega(@PathVariable Long id) {
        var entrega = Entregarepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoEntrega(entrega));
    }

}