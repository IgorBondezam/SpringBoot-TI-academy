package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Pedido;
import br.com.tiacademy.vendas.dto.PedidoCriarDTO;
import br.com.tiacademy.vendas.dto.PedidoDTO;
import br.com.tiacademy.vendas.repository.ClienteReporsitory;
import br.com.tiacademy.vendas.repository.ItemRepository;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PedidoConverter implements CrudConverter<Pedido, PedidoDTO> {

    private final ClienteConverter clienteConverter;
    private final VendedorConverter vendedorConverter;
    private final ItemConverter itemConverter;
    private final ClienteReporsitory clienteReporsitory;
    private final VendedorRepository vendedorRepository;
    private final ItemRepository itemRepository;

    @Override
    public PedidoDTO entidadeParaDTO(Pedido entidade) {

        var dto = new PedidoDTO();
        dto.setId(entidade.getId());
        dto.setData(entidade.getData());
        dto.setValor(entidade.getValor());
        dto.setCliente(clienteConverter.entidadeParaDTO(entidade.getCliente()));
        dto.setVendedor(vendedorConverter.entidadeParaDTO(entidade.getVendedor()));

        dto.getItens().addAll(entidade.getItens().stream().map(this.itemConverter::entidadeParaDTO).collect(Collectors.toList()));


        return dto;
    }

    @Override
    public Pedido dtoParaEntidade(PedidoDTO dto) {

        var pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setData(dto.getData());
        pedido.setValor(dto.getValor());

        pedido.setCliente(clienteReporsitory.findById(dto.getClienteId()).orElse(null));
        pedido.setVendedor(vendedorRepository.findById(dto.getVendedorId()).orElse(null));

        var itens = dto.getItens().stream().map(this.itemConverter::dtoParaEntidade).collect(Collectors.toList());

        pedido.getItens().addAll(itens);



        return pedido;
    }

    public Pedido dtoCriarParaEntidade(PedidoCriarDTO dto){
        var pedido = new Pedido();

        pedido.setCliente(clienteReporsitory.findById(dto.getClienteId()).orElse(null));
        pedido.setVendedor(vendedorRepository.findById(dto.getVendedorId()).orElse(null));

        return pedido;

    }

}
