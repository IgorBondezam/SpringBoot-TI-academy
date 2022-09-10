package br.com.tiacademy.vendas.fixture;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.domain.Pedido;
import br.com.tiacademy.vendas.domain.Vendedor;

public class PedidoFixture {

    public static Pedido criarPedidoConvertido(){
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente(1L, "Manuel"));
        pedido.setVendedor(new Vendedor(1L, "Joaquim"));

        return pedido;
    }

}
