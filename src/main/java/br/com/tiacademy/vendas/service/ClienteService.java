package br.com.tiacademy.vendas.service;


import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.repository.ClienteReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends CrudService<Cliente, Long> {

    @Override
    protected Cliente editarEntidade(Cliente recuperado, Cliente entidade){

        recuperado.setNome(entidade.getNome());

        return recuperado;
    }



}
