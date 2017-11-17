package br.com.fiap.dao.factories;

import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.dao.interfaces.IPedidoDao;

public abstract class DaoFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	
	public abstract IClienteDao getClienteDao();
	public abstract IPedidoDao getPedidoDao();
	
	public static DaoFactory getDaoFactory(int tipo){
		switch (tipo) {
		case MYSQL:
			return new MySqlDaoFactory();
		case SQLSERVER:
			return new SqlServerDaoFactory();
		default:
			return null;
		}
	}
}
