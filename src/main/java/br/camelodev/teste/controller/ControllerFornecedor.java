package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Fornecedor;
import br.camelodev.teste.getters.FornecedorDados;
import br.camelodev.teste.posts.FornecedorCadastro;
import br.camelodev.teste.puts.AtualizarDadosFornecedor;
import br.camelodev.teste.puts.DadosDetalhamentoFornecedor;
import br.camelodev.teste.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class ControllerFornecedor {

    @Autowired
    private FornecedorRepository Fornecedorrepo;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoFornecedor> cadastrarFornecedor(@RequestBody @Valid FornecedorCadastro dadosFornecedor, UriComponentsBuilder uriF) {
        var fornecedor = new Fornecedor(dadosFornecedor);
        Fornecedorrepo.save(new Fornecedor(dadosFornecedor));
        var uri = uriF.path("/fornecedor/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoFornecedor(fornecedor));
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDados>> listarFornecedor() {
        var lista =  Fornecedorrepo.findAllByStatusTrue().stream().map(FornecedorDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFornecedor> atualizarFornecedor(@RequestBody @Valid AtualizarDadosFornecedor dadosFornecedor) {
        var fornecedor = Fornecedorrepo.getReferenceById((long) dadosFornecedor.id());
        fornecedor.atualizarInformacoesFornecedor(dadosFornecedor);
        return ResponseEntity.ok(new DadosDetalhamentoFornecedor(fornecedor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirFornecedor(@PathVariable Long id) {
        Fornecedorrepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarFornecedor(@PathVariable Long id) {
        var cliente = Fornecedorrepo.getReferenceById(id);
        cliente.ativar();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarFornecedor(@PathVariable Long id) {
        var fornecedor = Fornecedorrepo.getReferenceById(id);
        fornecedor.inativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoFornecedor> detalharFornecedor(@PathVariable Long id) {
        var fornecedor = Fornecedorrepo.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoFornecedor(fornecedor));
    }
}