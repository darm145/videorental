package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;


public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cl) throws PersistenceException{
  try{
      clienteMapper.insertarCliente(cl);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el item "+cl.toString(),e);
  }        

  }

  @Override
  public Cliente load(int id) throws PersistenceException {
  try{
      return clienteMapper.consultarCliente(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el item "+id,e);
  }


  }

@Override
public List<Cliente> clientes() throws PersistenceException {
	try{
	      return clienteMapper.consultarClientes();
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar los clientes",e);
	  }
}

@Override
public void vetarCliente(long docu, boolean estado) throws PersistenceException {
	try{
	      clienteMapper.vetarCliente(docu,estado);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al actualizar estado del cliente",e);
	  }
	
}
}