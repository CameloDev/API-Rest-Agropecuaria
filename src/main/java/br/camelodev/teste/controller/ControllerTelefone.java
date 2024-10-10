package br.camelodev.teste.controller;

import br.camelodev.teste.entity.telefone;
import br.camelodev.teste.posts.TelefoneCadastro;
import br.camelodev.teste.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telefone")
public class ControllerTelefone {

    @Autowired
    private TelefoneRepository Telefone;
    @PostMapping
    public void cadastrarTelefone(@RequestBody TelefoneCadastro dadosTelefone) {
        Telefone.save(new telefone(dadosTelefone));
    }
}