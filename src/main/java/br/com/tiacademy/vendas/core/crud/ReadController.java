package br.com.tiacademy.vendas.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ReadController<T extends CrudDomain<ID>, D, ID> {

    @Autowired
    protected CrudService<T, ID> service;

    @Autowired
    protected CrudConverter<T, D> converter;

    @GetMapping
    public ResponseEntity<Page<D>> paginada(Pageable pageable){

        var listaPaginada = service.paginada(pageable).map(converter::entidadeParaDTO);

        return ResponseEntity.ok(listaPaginada);
    }



    @GetMapping("/lista")
    public ResponseEntity<List<D>> listar(){

        var listaDto = service.listar()
                .stream().map(converter::entidadeParaDTO).collect(Collectors.toList());


        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> especifico(@PathVariable("id") ID id){

        var entidade = service.porId(id);

        if(Objects.isNull(entidade)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(converter.entidadeParaDTO(entidade));

    }

}
