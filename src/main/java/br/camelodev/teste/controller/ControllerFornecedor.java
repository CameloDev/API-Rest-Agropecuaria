package br.camelodev.teste.controller;


import br.camelodev.teste.entity.fornecedor;
import br.camelodev.teste.posts.FornecedorCadastro;
import br.camelodev.teste.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fornecedor")
public class ControllerFornecedor {

    @Autowired
    private FornecedorRepository Fornecedor;
    @PostMapping
    public void cadastrarFornecedor(@RequestBody FornecedorCadastro dadosFornecedor) {
        Fornecedor.save(new fornecedor(dadosFornecedor));
    }
}