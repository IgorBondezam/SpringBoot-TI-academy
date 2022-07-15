package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> listar(){
        return vendedorRepository.findAll();


    }

    public Vendedor porId(Long id){
        return vendedorRepository.findById(id).orElse(null);
    }

    public Vendedor criar(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public Vendedor editar(Long id, Vendedor editado){

        var recupera = porId(id);
        if(Objects.isNull(recupera)){
            throw new RuntimeException("Não foi encontrado.");
        }
        recupera.setNome(editado.getNome());

        return vendedorRepository.save(recupera);
    }

    public void excluir(Long id){
        vendedorRepository.deleteById(id);
    }


}
