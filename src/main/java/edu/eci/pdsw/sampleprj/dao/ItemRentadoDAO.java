package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	   public ItemRentado load(int id) throws PersistenceException;
	   public void save(ItemRentado ir,long docu) throws PersistenceException;
	   
}
