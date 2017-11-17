package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IPedidoDao;

public class DeletePedidoTest {

	public static void main(String[] args) {
		// delete pedido from cliente
		
		IPedidoDao dao = MySqlDaoFactory.getDaoFactory(1).getPedidoDao();
		
		try {
			dao.deletePedido(5);
			System.out.println("Pedido deletado");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
