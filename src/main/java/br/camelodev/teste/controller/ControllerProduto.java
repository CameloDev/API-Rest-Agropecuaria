package br.camelodev.teste.controller;



import br.camelodev.teste.entity.Produto;
import br.camelodev.teste.getters.ProdutoDados;
import br.camelodev.teste.posts.ProdutoCadastro;
import br.camelodev.teste.puts.AtualizarDadosProduto;
import br.camelodev.teste.puts.DadosDetalhamentoProduto;
import br.camelodev.teste.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ControllerProduto {

    @Autowired
    private ProdutoRepository Produtorepo;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoProduto> cadastrarProduto(@RequestBody @Valid ProdutoCadastro dadosProduto, UriComponentsBuilder uriF) {
        var produto = new Produto(dadosProduto);
        Produtorepo.save(new Produto(dadosProduto));
        var uri = uriF.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDados>> listarProduto() {
        var lista = Produtorepo.findAllByStatusTrue().stream().map(ProdutoDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> atualizarProduto(@RequestBody @Valid AtualizarDadosProduto dadosProduto) {
        var produto = Produtorepo.getReferenceById(dadosProduto.id());
        produto.atualizarInformacoesProduto(dadosProduto);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        Produtorepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProduto> detalharProduto(@PathVariable Long id) {
        var produto = Produtorepo.getReferenceById(Math.toIntExact(id));
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }
    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarProduto(@PathVariable Long id) {
        var produto = Produtorepo.getReferenceById(Math.toIntExact(id));
        produto.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarProduto(@PathVariable Long id) {
        var produto = Produtorepo.getReferenceById(Math.toIntExact(id));
        produto.ativar();
        return ResponseEntity.noContent().build();
    }
}
