package br.com.tiacademy.vendas.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class CrudController<T extends CrudDomain<ID> , D, ID> extends ReadController<T, D, ID> {


    @PostMapping
    public ResponseEntity<D> criar(@RequestBody D dto){

        var entidade = converter.dtoParaEntidade(dto);
        var salvo = service.criar(entidade);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();

        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();

        return ResponseEntity.created(uri).body(converter.entidadeParaDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> editar(@PathVariable("id") ID id, @RequestBody D dto){

        var NovaEntidade = converter.dtoParaEntidade(dto);
        var salvo = service.editar(id, NovaEntidade);

        return ResponseEntity.ok(converter.entidadeParaDTO(salvo));

    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable("id") ID id){
        service.excluir(id);
        return  ResponseEntity.noContent().build();
    }



}
