package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.entity.Cliente;

/**
 * Interface to be implemented for any dao Class
 *
 */
public interface IClienteDao {
	Cliente insertCliente(Cliente cliente) throws Exception;
	void deleteCliente(int id) throws Exception;
	Cliente updateCliente(Cliente cliente) throws Exception;
	Cliente findCliente(int id) throws Exception;
	List<Cliente> clientes() throws Exception;
}
