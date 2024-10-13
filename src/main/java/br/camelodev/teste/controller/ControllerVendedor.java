package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Telefone;
import br.camelodev.teste.entity.Vendedor;
import br.camelodev.teste.getters.TelefoneDados;
import br.camelodev.teste.getters.VendedorDados;
import br.camelodev.teste.posts.TelefoneCadastro;
import br.camelodev.teste.posts.VendedorCadastro;
import br.camelodev.teste.puts.AtualizarDadosTelefone;
import br.camelodev.teste.puts.AtualizarDadosVendedor;
import br.camelodev.teste.puts.DadosDetalhamentoTelefone;
import br.camelodev.teste.puts.DadosDetalhamentoVendedor;
import br.camelodev.teste.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
public class ControllerVendedor {

    @Autowired
    private VendedorRepository Vendedorrepo;
    @PostMapping
    public ResponseEntity<DadosDetalhamentoVendedor> cadastrarVendedor(@RequestBody @Valid VendedorCadastro dadosVendedor, UriComponentsBuilder uriF) {
        var vendedor = new Vendedor(dadosVendedor);
        Vendedorrepo.save(new Vendedor(dadosVendedor));
        var uri = uriF.path("/vendedor/{id}").buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVendedor(vendedor));
    }

    @GetMapping
    public ResponseEntity<List<VendedorDados>> listarVendedor() {
        var lista = Vendedorrepo.findAllByStatusTrue().stream().map(VendedorDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoVendedor> atualizarVendedor(@RequestBody @Valid AtualizarDadosVendedor dadosVendedor) {
        var vendedor = Vendedorrepo.getReferenceById(dadosVendedor.id());
        vendedor.atualizarInformacoesVendedor(dadosVendedor);
        return ResponseEntity.ok(new DadosDetalhamentoVendedor(vendedor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirVendedor(@PathVariable Long id) {
        Vendedorrepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoVendedor> detalharVendedor(@PathVariable Long id) {
        var vendedor = Vendedorrepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoVendedor(vendedor));
    }


    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarVendedor(@PathVariable Long id) {
        var vendedor = Vendedorrepo.getReferenceById(Math.toIntExact(id));
        vendedor.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarVendedor(@PathVariable Long id) {
        var vendedor = Vendedorrepo.getReferenceById(Math.toIntExact(id));
        vendedor.ativar();
        return ResponseEntity.noContent().build();
    }
}