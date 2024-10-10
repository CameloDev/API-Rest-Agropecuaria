package br.camelodev.teste.controller;

import br.camelodev.teste.entity.funcionario;
import br.camelodev.teste.posts.FuncionarioCadastro;

import br.camelodev.teste.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class ControllerFuncionario {

    @Autowired
    private FuncionarioRepository Funcionario;
    @PostMapping
    public void cadastrarPedido(@RequestBody FuncionarioCadastro dadosfuncionario) {
        Funcionario.save(new funcionario(dadosfuncionario));
    }
}