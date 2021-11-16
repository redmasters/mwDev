package br.com.redmaster.projetoempresa.repository;

import br.com.redmaster.projetoempresa.model.Departamentos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartamentosRepository extends CrudRepository<Departamentos, Long> {

    List<Departamentos> findByAndar(int andarNumero);

}
