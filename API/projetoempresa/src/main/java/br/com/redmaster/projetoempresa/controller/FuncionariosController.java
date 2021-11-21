package br.com.redmaster.projetoempresa.controller;

import br.com.redmaster.projetoempresa.model.Funcionarios;
import br.com.redmaster.projetoempresa.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FuncionariosController {

    @Autowired
    FuncionariosRepository funcionariosRepository;

    @GetMapping("/funcionarios")
    public ArrayList<Funcionarios> listarFuncionarios(){
        return (ArrayList<Funcionarios>) funcionariosRepository.findAll();
    }

}
