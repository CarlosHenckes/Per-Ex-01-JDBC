package br.com.fiap.dao.factories;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.dao.interfaces.IPedidoDao;

public class SqlServerDaoFactory extends DaoFactory {

	public static final String DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	public static final String URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=venda";
	
	public static Connection criarConexao() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, "root", "root");
	}
	
	@Override
	public IClienteDao getClienteDao() {
		return null;
	}

	@Override
	public IPedidoDao getPedidoDao() {
		return null;
	}

}
