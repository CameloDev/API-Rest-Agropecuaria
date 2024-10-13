package br.camelodev.teste.controller;


import br.camelodev.teste.entity.Endereco;
import br.camelodev.teste.getters.EnderecoDados;
import br.camelodev.teste.posts.EnderecoCadastro;
import br.camelodev.teste.puts.AtualizarDadosEndereco;
import br.camelodev.teste.puts.DadosDetalhamentoEndereco;
import br.camelodev.teste.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class ControllerEndereco {

    @Autowired
    private EnderecoRepository Enderecorepo;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoEndereco> cadastrarEndereco(@RequestBody @Valid EnderecoCadastro dadosEndereco, UriComponentsBuilder uriE) {
        var endereco = new Endereco(dadosEndereco);
        Enderecorepo.save(new Endereco(dadosEndereco));
        var uri = uriE.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDados>> listarEndereco() {
        var lista =  Enderecorepo.findAll().stream().map(EnderecoDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEndereco> atualizarEndereco(@RequestBody @Valid AtualizarDadosEndereco dadosEndereco) {
        var endereco = Enderecorepo.getReferenceById(Math.toIntExact(dadosEndereco.id()));
        endereco.atualizarInformacoesEndereco(dadosEndereco);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirEndereco(@PathVariable Long id) {
        Enderecorepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEndereco> detalharEndereco(@PathVariable Long id) {
        var endereco = Enderecorepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }
}
