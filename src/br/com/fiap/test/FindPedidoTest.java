package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IPedidoDao;

public class FindPedidoTest {

	public static void main(String[] args) {
		
		// find specified pedido by its id
		
		IPedidoDao dao = MySqlDaoFactory.getDaoFactory(1).getPedidoDao();
		
		try {
			System.out.println(dao.findPedido(2).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
