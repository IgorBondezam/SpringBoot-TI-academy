package br.com.tiacademy.vendas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoCriarDTO {

    private Long clienteId;
    private Long vendedorId;
    private List<ItemPedidoDTO> itens = new ArrayList<>();

}
