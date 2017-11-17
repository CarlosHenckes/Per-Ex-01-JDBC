package br.com.fiap.dao.factories;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.fiap.dao.MySQLClienteDao;
import br.com.fiap.dao.MySQLPedidoDao;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.dao.interfaces.IPedidoDao;

public class MySqlDaoFactory extends DaoFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/venda";
	
	public static Connection criarConexao() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, "root", "root");
	}
	
	@Override
	public IClienteDao getClienteDao() {
		return new MySQLClienteDao();
	}

	@Override
	public IPedidoDao getPedidoDao() {
		return new MySQLPedidoDao();
	}

}
