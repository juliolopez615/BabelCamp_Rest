package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	public boolean altaPedido(Pedido pedido);
	public List<Pedido> pedidos();
}
