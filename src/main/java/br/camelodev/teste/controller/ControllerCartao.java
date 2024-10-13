package br.camelodev.teste.controller;

import br.camelodev.teste.entity.Cartao;
import br.camelodev.teste.getters.CartaoDados;
import br.camelodev.teste.posts.CartaoCadastro;
import br.camelodev.teste.puts.AtualizarDadosCartao;
import br.camelodev.teste.puts.DadosDetalhamentoCartao;
import br.camelodev.teste.repository.CartaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cartao")
public class ControllerCartao {

    @Autowired
    private CartaoRepository Cartaorepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCartao> cadastrarCartao(@RequestBody @Valid CartaoCadastro dadosCartao, UriComponentsBuilder uriBuilder ) {
        var cartao = new Cartao(dadosCartao);
        Cartaorepository.save(cartao);
        var uri = uriBuilder.path("/cartao/{id}").buildAndExpand(cartao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCartao(cartao));
    }

    @GetMapping()
    public ResponseEntity<List<CartaoDados>> listarCartao() {
        var lista =  Cartaorepository.findAllByStatuscartaoTrue().stream().map(CartaoDados::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCartao> atualizarCartao(@RequestBody @Valid AtualizarDadosCartao dadosCartao) {
        var cartao = Cartaorepository.getReferenceById((long) dadosCartao.id());
        cartao.atualizarInformacoesCartao(dadosCartao);
        return ResponseEntity.ok(new DadosDetalhamentoCartao(cartao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirCartao(@PathVariable Long id) {
        Cartaorepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarCartao(@PathVariable Long id) {
        var cartao = Cartaorepository.getReferenceById(id);
        cartao.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarCartao(@PathVariable Long id) {
        var cartao = Cartaorepository.getReferenceById(id);
        cartao.ativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCartao> detalharCartao(@PathVariable Long id) {
        var cartao = Cartaorepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCartao(cartao));
    }
}
