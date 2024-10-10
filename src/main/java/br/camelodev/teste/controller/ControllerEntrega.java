package br.camelodev.teste.controller;

import br.camelodev.teste.entity.entrega;
import br.camelodev.teste.posts.EntregaCadastro;
import br.camelodev.teste.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entrega")
public class ControllerEntrega {

    @Autowired
    private EntregaRepository Entrega;
    @PostMapping
    public void cadastrarEntrega(@RequestBody EntregaCadastro dadosEntrega) {
        Entrega.save(new entrega(dadosEntrega));
    }
}