package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Telefone;
import br.camelodev.teste.getters.TelefoneDados;
import br.camelodev.teste.posts.TelefoneCadastro;
import br.camelodev.teste.puts.DadosDetalhamentoTelefone;
import br.camelodev.teste.repository.TelefoneRepository;
import br.camelodev.teste.puts.AtualizarDadosTelefone;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/telefone")
public class ControllerTelefone {

    @Autowired
    private TelefoneRepository Telefonerepo;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTelefone> cadastrarTelefone(@RequestBody @Valid TelefoneCadastro dadosTelefone, UriComponentsBuilder uriF) {
        var telefone = new Telefone(dadosTelefone);
        Telefonerepo.save(new Telefone(dadosTelefone));
        var uri = uriF.path("/telefone/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTelefone(telefone));
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDados>> listarTelefone() {
        var lista =  Telefonerepo.findAll().stream().map(TelefoneDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTelefone> atualizarTelefone(@RequestBody @Valid AtualizarDadosTelefone dadosTelefone) {
        var telefone = Telefonerepo.getReferenceById(dadosTelefone.id());
        telefone.atualizarInformacoesTelefone(dadosTelefone);
        return ResponseEntity.ok(new DadosDetalhamentoTelefone(telefone));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirTelefone(@PathVariable Long id) {
        Telefonerepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTelefone> detalharTelefone(@PathVariable Long id) {
        var telefone = Telefonerepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoTelefone(telefone));
    }
}