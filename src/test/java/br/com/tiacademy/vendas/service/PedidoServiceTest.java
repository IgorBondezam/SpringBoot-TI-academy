package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.fixture.ItemFixture;
import br.com.tiacademy.vendas.fixture.PedidoCriarDTOFixture;
import br.com.tiacademy.vendas.fixture.PedidoFixture;
import br.com.tiacademy.vendas.repository.ItemRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    private PedidoService pedidoService;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void setUp(){
        pedidoService = new PedidoService(itemRepository);
    }

    @Test
    public void deveCriarPedido(){

        var pedido = PedidoFixture.criarPedidoConvertido();
        var dto = PedidoCriarDTOFixture.criarDTO();

        Mockito.when(itemRepository.findByIdIn(ArgumentMatchers.anyList())).thenReturn(Collections.singletonList(ItemFixture.criar()));

        var resultado = pedidoService.criarPedido(pedido, dto);

        Assertions.assertNotNull(resultado);
        MatcherAssert.assertThat(resultado.getValor(), CoreMatchers.equalTo(BigDecimal.valueOf(105.78)));

    }

}
