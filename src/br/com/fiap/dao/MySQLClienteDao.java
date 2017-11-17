package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IClienteDao;
import br.com.fiap.entity.Cliente;

/**
 * crud for Cliente
 * 
 */
public class MySQLClienteDao implements IClienteDao {
	
	Connection conn = null;
	ResultSet rs;
	PreparedStatement ps;
	
	/**
	 * Persists new Cliente do database
	 * @param Cliente cliente
	 * @return Cliente
	 * @throws Exception
	 */
	@Override
	public Cliente insertCliente(Cliente cliente) throws Exception {
		String sql = "Insert into Cliente (nome, email) values(?,?)";
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.execute();
			
			rs = ps.getGeneratedKeys();
			while (rs.next()){
				cliente.setIdCliente(rs.getInt(1));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return cliente;
	}
	
	/**
	 * List of Cliente from database
	 * @param none
	 * @return List<Cliente>
	 * @throws Exception
	 */
	@Override
	public List<Cliente> clientes() throws Exception {
		List<Cliente> c = new ArrayList<Cliente>();
		String sql = "select idCliente, nome, email from Cliente order by nome ASC";

		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return c;
	}

	/**
	 * Delete Cliente from database
	 * @param int id
	 * @return void
	 * @throws Exception
	 */
	@Override
	public void deleteCliente(int id) throws Exception {
		String sql = "delete from Cliente where idcliente = ?";
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
	}

	/**
	 * Udpate information about the Cliente
	 * @param Cliente cliente
	 * @return Cliente
	 * @throws Exception
	 */
	@Override
	public Cliente updateCliente(Cliente cliente) throws Exception {
		String sql = "update Cliente set nome = ?, email = ? "
				+ "where idCliente = ?";
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setInt(3, cliente.getIdCliente());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return cliente;
	}

	/**
	 * Find Cliente from its id
	 * @param int id
	 * @return Cliente
	 * @throws Exception
	 */
	@Override
	public Cliente findCliente(int id) throws Exception {
		String sql = "select idcliente, nome, email "
				+ "from Cliente where idcliente = ?";
		Cliente cliente = new Cliente();
		
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()){
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setEmail(rs.getString(3));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return cliente;
	}

}
