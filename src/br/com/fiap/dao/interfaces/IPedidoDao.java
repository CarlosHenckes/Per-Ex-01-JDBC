package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface IPedidoDao {
	Pedido insertPedido(Pedido pedido) throws Exception;
	Pedido updatePedido(Pedido pedido) throws Exception;
	void deletePedido(int id) throws Exception;
	Pedido findPedido(int idPedido) throws Exception;
	List<Pedido> listPedidos(int idCliente) throws Exception;
}
