package br.com.tiacademy.vendas.controller;


import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.service.ClienteService;
import liquibase.pro.packaged.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarCli(){

        var clientes = clienteService.ListarCli();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> cliEspecifico(@PathVariable("id") Long id){

        var resultado = clienteService.cliPorId(id);

        if(Objects.isNull(resultado)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);

    }

    @PostMapping
    public ResponseEntity<Cliente> criarCli(@RequestBody Cliente cliente){
        var salvo = clienteService.criarCli(cliente);

        return ResponseEntity.ok(salvo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCli(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        if(clienteService.editarCli(id, cliente) == null){
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(clienteService.editarCli(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCli(@PathVariable("id") Long id){

        //Verifica se o id existe
        var resultado = clienteService.cliPorId(id);

        if(Objects.isNull(resultado)){
            return ResponseEntity.notFound().build();
        }

        //exclue o id se ele existir

        clienteService.deletarCli(id);

        return ResponseEntity.ok().build();
    }





}
