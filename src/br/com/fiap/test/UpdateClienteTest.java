package br.com.fiap.test;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.entity.Cliente;

public class UpdateClienteTest {

	public static void main(String[] args) {
		
		// update cliente information
		
		try {
		// construct cliente dao
			
		// invoque method
		IClienteDao dao = MySqlDaoFactory.getDaoFactory(1).getClienteDao();
		
			// cliente before update
			Cliente co = dao.findCliente(6);
			System.out.println("--- Cliente antes da atualização ---");
			System.out.println(co.toString());
		
			Cliente cd = dao.updateCliente(
					new Cliente(6, "Jilcelia Magda Vanini", "jmvanini@uol.com.br"));
			System.out.println("--- cliente após atualização ---");
			System.out.println(cd.toString());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
