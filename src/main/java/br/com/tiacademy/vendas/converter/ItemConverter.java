package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.core.crud.CrudDomain;
import br.com.tiacademy.vendas.domain.Item;
import br.com.tiacademy.vendas.dto.ItemDTO;
import br.com.tiacademy.vendas.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter implements CrudConverter<Item, ItemDTO> {

    @Autowired
    private ServicoConverter servicoConverter;

    @Autowired
    private ServicoRepository servicoRepository;


    @Override
    public ItemDTO entidadeParaDTO(Item entidade) {

        var dto = new ItemDTO();
        dto.setId(entidade.getId());
        dto.setQuantidade(entidade.getQuantidade());
        dto.setValor(entidade.getValor());
        dto.setServico(servicoConverter.entidadeParaDTO(entidade.getServico()));

        return dto;
    }

    @Override
    public Item dtoParaEntidade(ItemDTO dto) {

        var item = new Item();
        item.setId(dto.getId());
        item.setQuantidade(dto.getQuantidade());
        item.setValor(dto.getValor());
        item.setServico(servicoRepository.findById(dto.getServicoId()).orElse(null));

        return item;
    }
}
