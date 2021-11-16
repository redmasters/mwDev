package br.com.redmaster.projetoempresa.controller;

import br.com.redmaster.projetoempresa.model.Departamentos;
import br.com.redmaster.projetoempresa.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/departamentos")
public class DepartamentosController {

    @Autowired
    DepartamentosRepository departamentosRepository;

    @GetMapping(path = "/andar/{id}")
    public List<Departamentos> buscarPorAndar(@PathVariable Long andarNumero){
        return departamentosRepository.findTopByAndar(andarNumero);
    }


}
