package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Servico;
import br.com.tiacademy.vendas.dto.ServicoDTO;
import org.springframework.stereotype.Component;

@Component
public class ServicoConverter implements CrudConverter<Servico, ServicoDTO> {
    @Override
    public ServicoDTO entidadeParaDTO(Servico entidade) {
        return new ServicoDTO(entidade.getId(), entidade.getNome(), entidade.getDescricao());
    }

    @Override
    public Servico dtoParaEntidade(ServicoDTO dto) {
        return new Servico(dto.getId(), dto.getNome(), dto.getDescricao());
    }
}
