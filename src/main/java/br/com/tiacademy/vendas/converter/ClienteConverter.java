package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter implements CrudConverter<Cliente, ClienteDTO> {
    @Override
    public ClienteDTO entidadeParaDTO(Cliente entidade) {
        return new ClienteDTO(entidade.getId(), entidade.getNome());
    }

    @Override
    public Cliente dtoParaEntidade(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getNome());
    }
}
