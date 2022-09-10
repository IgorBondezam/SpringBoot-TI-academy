package br.com.tiacademy.vendas.fixture;

import br.com.tiacademy.vendas.dto.ItemPedidoDTO;

public class ItemPedidoDTOFixture {

    public static ItemPedidoDTO criarDTO(){

        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(1L);
        return dto;

    }

}
