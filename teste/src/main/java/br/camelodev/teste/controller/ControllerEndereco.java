package br.camelodev.teste.controller;


import br.camelodev.teste.entity.endereco;
import br.camelodev.teste.posts.EnderecoCadastro;
import br.camelodev.teste.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/endereco")
public class ControllerEndereco {

    @Autowired
    private EnderecoRepository Endereco;
    @PostMapping
    public void cadastrarEndereco(@RequestBody EnderecoCadastro dadosEndereco) {
        Endereco.save(new endereco(dadosEndereco));
    }
}
