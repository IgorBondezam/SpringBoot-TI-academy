package br.com.tiacademy.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;


}
