package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Servico;
import org.springframework.stereotype.Service;

@Service
public class ServiceServico extends CrudService<Servico, Long> {
    @Override
    protected Servico editarEntidade(Servico recuperado, Servico entidade) {
        recuperado.setId(entidade.getId());
        recuperado.setDescricao(entidade.getDescricao());
        recuperado.setNome(entidade.getNome());

        return recuperado;
    }
}
