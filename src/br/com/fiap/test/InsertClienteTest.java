package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.entity.Cliente;

public class InsertClienteTest {

	public static void main(String[] args) {
		
		IClienteDao dao = MySqlDaoFactory.getDaoFactory(1).getClienteDao();
		try {
			Cliente cliente = dao.insertCliente(new Cliente(0, "Jil Vanini Henckes", "jmvanini@uol.com.br"));
			System.out.println(cliente.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
