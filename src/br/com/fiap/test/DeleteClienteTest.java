package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;

public class DeleteClienteTest {

	public static void main(String[] args) {
		// simple cliente remove that has no pedidos
		
		try {
			// construct dao
			IClienteDao dao = MySqlDaoFactory.getDaoFactory(1).getClienteDao();
			dao.deleteCliente(2);
			System.out.println("Cliente removido");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
