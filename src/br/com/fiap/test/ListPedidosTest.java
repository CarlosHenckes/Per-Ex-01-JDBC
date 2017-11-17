package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IPedidoDao;
import br.com.fiap.entity.Pedido;

public class ListPedidosTest {

	public static void main(String[] args) {
		// list of pedidos for a given cliente
		
		IPedidoDao dao = MySqlDaoFactory.getDaoFactory(1).getPedidoDao();
		
		try {
			// list pedidos for cliente 4
			for (Pedido pedido : dao.listPedidos(4)) {
				System.out.println(pedido.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
