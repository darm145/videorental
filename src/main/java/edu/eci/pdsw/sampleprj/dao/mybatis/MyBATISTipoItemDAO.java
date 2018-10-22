package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	@Inject
	private TipoItemMapper tipoItemMapper;
	@Override
	public void save(TipoItem ti) throws PersistenceException {
		 try{
		      tipoItemMapper.addTipoItem(ti.getDescripcion());
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar el Tipo item "+ti.toString(),e);
		  }
		
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {
		try{
		      return tipoItemMapper.getTipoItem(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al cargar el tipo item"+id,e);
		  }
	}

	@Override
	public List<TipoItem> getTiposItems() throws PersistenceException {
		try{
		      return tipoItemMapper.getTiposItems();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al cargar los tipos Items",e);
		  }
	}

}
