package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VendedorService extends CrudService<Vendedor, Long> {

    @Override
    protected Vendedor editarEntidade(Vendedor recuperado, Vendedor entidade){

        recuperado.setNome(entidade.getNome());

        return recuperado;
    }



}
