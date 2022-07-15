package br.com.tiacademy.vendas.service;


import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.repository.ClienteReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteReporsitory clienteReporsitory;

    public List<Cliente> ListarCli(){
        return clienteReporsitory.findAll();
    }


    public Cliente cliPorId(Long id){
        return clienteReporsitory.findById(id).orElse(null);
    }

    public Cliente criarCli(Cliente cliente){
        return clienteReporsitory.save(cliente);
    }

    public Cliente editarCli(Long id, Cliente editado){

        var pegarId = cliPorId(id);
        if(pegarId == null){
            return null;
        }
        pegarId.setNome(editado.getNome());

        return clienteReporsitory.save(pegarId);

    }

    public void deletarCli(Long id){
        clienteReporsitory.deleteById(id);
    }


}
