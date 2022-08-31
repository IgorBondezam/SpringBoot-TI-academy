package br.com.tiacademy.vendas.dto;

import br.com.tiacademy.vendas.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO implements Serializable {

    private Long id;
    private LocalDate data;
    private BigDecimal valor;

    private Long vendedorId;
    private Long clienteId;

    private ClienteDTO cliente;
    private VendedorDTO vendedor;

    private List<ItemDTO> itens = new ArrayList<>();


}
