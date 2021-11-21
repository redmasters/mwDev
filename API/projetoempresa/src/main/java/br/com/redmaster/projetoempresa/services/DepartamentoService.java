package br.com.redmaster.projetoempresa.services;

import br.com.redmaster.projetoempresa.model.Departamentos;
import br.com.redmaster.projetoempresa.repository.DepartamentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentosRepository departamentosRepository;

    public DepartamentoService(DepartamentosRepository departamentosRepository) {
        this.departamentosRepository = departamentosRepository;
    }

}
