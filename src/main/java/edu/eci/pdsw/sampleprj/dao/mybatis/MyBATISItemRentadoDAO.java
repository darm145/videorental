package edu.eci.pdsw.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.ItemRentado;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{
	@Inject
	  private ItemRentadoMapper ItemRentadoMapper;
	@Override
	public ItemRentado load(int id) throws PersistenceException {
		try{
		      return ItemRentadoMapper.getItemRentado(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el item Rentado"+ id,e);
		  }        

	}
	@Override
	public void save(ItemRentado ir,long docu) throws PersistenceException {
		try{
		      ItemRentadoMapper.saveItemRentado(ir,docu);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al guardar el registro",e);
		  }
		
	}

}
