package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.entity.Cliente;

public class ListClientesTest {

	public static void main(String[] args) {
		
		IClienteDao dao = MySqlDaoFactory.getDaoFactory(1).getClienteDao();
		
		try {
			for (Cliente c : dao.clientes()) {
				System.out.println(c.toString());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
