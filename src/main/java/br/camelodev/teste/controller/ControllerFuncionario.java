package br.camelodev.teste.controller;


import br.camelodev.teste.entity.Funcionario;
import br.camelodev.teste.getters.FuncionarioDados;
import br.camelodev.teste.posts.FuncionarioCadastro;
import br.camelodev.teste.puts.AtualizarDadosFuncionario;
import br.camelodev.teste.puts.DadosDetalhamentoFuncionario;
import br.camelodev.teste.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class ControllerFuncionario {

    @Autowired
    private FuncionarioRepository Funcionariorepo;
    @PostMapping
    public ResponseEntity<DadosDetalhamentoFuncionario> cadastrarFuncionario(@RequestBody @Valid FuncionarioCadastro dadosFuncionario, UriComponentsBuilder uriF) {
        var funcionario = new Funcionario(dadosFuncionario);
        Funcionariorepo.save(new Funcionario(dadosFuncionario));
        var uri = uriF.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDados>> listarFuncionario() {
        var lista =  Funcionariorepo.findAll().stream().map(FuncionarioDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFuncionario> atualizarFuncionario(@RequestBody @Valid AtualizarDadosFuncionario dadosFuncionario) {
        var funcionario = Funcionariorepo.getReferenceById(dadosFuncionario.id());
        funcionario.atualizarInformacoesFuncionario(dadosFuncionario);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        Funcionariorepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoFuncionario> detalharFuncionario(@PathVariable Long id) {
        var funcionario = Funcionariorepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }
}