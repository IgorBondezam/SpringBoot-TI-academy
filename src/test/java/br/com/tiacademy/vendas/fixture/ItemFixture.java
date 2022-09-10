package br.com.tiacademy.vendas.fixture;

import br.com.tiacademy.vendas.domain.Item;
import br.com.tiacademy.vendas.domain.Servico;

import java.math.BigDecimal;

public class ItemFixture {

    public static Item criar(){
        var item = new Item();
        item.setId(1L);
        item.setQuantidade(2);
        item.setValor(BigDecimal.valueOf(52.89));
        item.setServico(new Servico());
        return item;
    }
}
