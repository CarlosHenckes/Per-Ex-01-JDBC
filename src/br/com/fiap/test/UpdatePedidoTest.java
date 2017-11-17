package br.com.fiap.test;

import java.util.Calendar;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IPedidoDao;
import br.com.fiap.entity.Pedido;

public class UpdatePedidoTest {

	public static void main(String[] args) {
		// update some pedido data
		
		IPedidoDao dao = MySqlDaoFactory.getDaoFactory(1).getPedidoDao();
		
		try {
			Pedido po = dao.findPedido(1);
			// display current pedido
			System.out.println("--- current pedido ---");
			System.out.println(po.toString());
			
			// update pedido info
			Pedido pn = dao.updatePedido(new Pedido(1, 4, 
						new java.sql.Date(Calendar.getInstance().getTimeInMillis()), "Bolas de golfe", 32));
			System.out.println("--- updated pedido ---");
			System.out.println(po.toString());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
