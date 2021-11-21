package br.com.redmaster.projetoempresa.controller;

import br.com.redmaster.projetoempresa.model.Departamentos;
import br.com.redmaster.projetoempresa.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartamentosController {

    @Autowired
    DepartamentosRepository departamentosRepository;

    @GetMapping("/departamentos")
    public ArrayList<Departamentos> listarDepartamentos(){
        return (ArrayList<Departamentos>) departamentosRepository.findAll();
    }


}
