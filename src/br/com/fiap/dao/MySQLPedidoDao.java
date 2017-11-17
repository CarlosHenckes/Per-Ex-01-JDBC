package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.dao.factories.MySqlDaoFactory;
import br.com.fiap.dao.interfaces.IPedidoDao;
import br.com.fiap.entity.Pedido;

/**
 * Method that persists a new pedido to database
 * @param Pedido pedido
 * @return Pedido
 * @throws Exception
 */
public class MySQLPedidoDao implements IPedidoDao {
	
	Connection conn = null;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * Method that persists a new pedido to database
	 * @param Pedido pedido
	 * @return Pedido
	 * @throws Exception
	 */
	@Override
	public Pedido insertPedido(Pedido pedido) throws Exception {
		
		String sql = "Insert into Pedido (idCliente, data, descricao, valor) "
				+ "values (?, ?, ?, ?)";
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pedido.getIdCliente());
			ps.setDate(2, pedido.getData());
			ps.setString(3, pedido.getDescricao());
			ps.setDouble(4, pedido.getValor());
			ps.execute();
			rs = ps.getGeneratedKeys();
			
			while (rs.next()){
				pedido.setIdPedido(rs.getInt(1));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return pedido;
	}

	/**
	 * Method updates Pedido
	 * @param Pedido pedido
	 * @return Pedido
	 * @throws Exception
	 */
	@Override
	public Pedido updatePedido(Pedido pedido) throws Exception {
		String sql = "update pedido set data = ?, descricao = ?, valor = ? where idpedido = ?";
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setDate(1, pedido.getData());
			ps.setString(2, pedido.getDescricao());
			ps.setDouble(3, pedido.getValor());
			ps.setInt(4, pedido.getIdPedido());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return pedido;
	}

	/**
	 * Method that deletes a pedido from database
	 * @param Integer id
	 * @return void
	 * @throws Exception
	 */
	@Override
	public void deletePedido(int id) throws Exception {
		String sql = "delete from pedido where idpedido = ?";
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
	 * Method recover a pedido from database
	 * @param Integer idpedido
	 * @return Pedido
	 * @throws Exception
	 */
	@Override
	public Pedido findPedido(int idPedido) throws Exception {
		String sql = "select idpedido, idcliente, data, descricao, valor "
				+ "from pedido where idpedido = ?";
		Pedido p = new Pedido();
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPedido);
			rs = ps.executeQuery();
			if (rs.next()){
				p.setIdPedido(rs.getInt(1));
				p.setIdCliente(rs.getInt(2));
				p.setData(rs.getDate(3));
				p.setDescricao(rs.getString(4));
				p.setValor(rs.getDouble(5));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return p;
	}

	/**
	 * Method that return a list of Pedidos for given cliente
	 * @param Integer idcliente
	 * @return List of Pedido
	 * @throws Exception
	 */
	@Override
	public List<Pedido> listPedidos(int idCliente) throws Exception {
		String sql = "select idpedido, idcliente, descricao, data, valor "
				+ "from Pedido where idcliente = ?";
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			conn = MySqlDaoFactory.criarConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			
			while(rs.next()){
				pedidos.add(new Pedido(rs.getInt(1), rs.getInt(2), 
						rs.getDate(3), rs.getString(4), rs.getDouble(5)));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			conn.close();
		}
		return pedidos;
	}

}
