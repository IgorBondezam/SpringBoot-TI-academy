package br.com.tiacademy.vendas.fixture;

import br.com.tiacademy.vendas.domain.Pedido;
import br.com.tiacademy.vendas.dto.PedidoCriarDTO;

public class PedidoCriarDTOFixture {

    public static PedidoCriarDTO criarDTO(){

        PedidoCriarDTO dto = new PedidoCriarDTO();
        dto.setClienteId(1L);
        dto.setVendedorId(1L);
        dto.getItens().add(ItemPedidoDTOFixture.criarDTO());
        return dto;
    }

}
