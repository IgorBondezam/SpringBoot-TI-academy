package br.com.tiacademy.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

    private Long id;
    private Integer quantidade;
    private BigDecimal valor;
    private ServicoDTO servico;
    private Long servicoId;

}
