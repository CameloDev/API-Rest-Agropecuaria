package br.camelodev.teste.controller;

import br.camelodev.teste.entity.vendedor;
import br.camelodev.teste.posts.VendedorCadastro;
import br.camelodev.teste.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendedor")
public class ControllerVendedor {

    @Autowired
    private VendedorRepository Vendedor;
    @PostMapping
    public void cadastrarVendedor(@RequestBody VendedorCadastro dadosVendedor) {
        Vendedor.save(new vendedor(dadosVendedor));
    }
}