package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();      
    public List<Item> consultarItemsDisponibles();
    
    public Item consultarItem(@Param("Item")int id);
    
    public void insertarItem(@Param("item")Item it);
	public void updateTarifa(@Param("id") int id,@Param("tarifa") long tarifa);

        
}
