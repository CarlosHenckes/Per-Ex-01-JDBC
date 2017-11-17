package br.com.fiap.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.fiap.dao.MySQLClienteDao;
import br.com.fiap.dao.MySQLPedidoDao;
import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.dao.interfaces.IPedidoDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class InsertPedidoClienteTest {

	public static void main(String[] args) {
		
		IClienteDao daoCliente = MySqlDaoFactory.getDaoFactory(1).getClienteDao();
		IPedidoDao daoPedido = MySqlDaoFactory.getDaoFactory(1).getPedidoDao();
		
		try {
			// create new cliente
			Cliente cliente = daoCliente.insertCliente(new Cliente("Sabryna Coltro", "sabryna@femorale.com"));
			System.out.println(cliente.toString());
			
			// create new pedido
			Pedido pedido = daoPedido.insertPedido(new Pedido(cliente.getIdCliente(), 
					new Date(Calendar.getInstance().getTimeInMillis()), "Kit MaryKay", 632.0));
			System.out.println(pedido.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
