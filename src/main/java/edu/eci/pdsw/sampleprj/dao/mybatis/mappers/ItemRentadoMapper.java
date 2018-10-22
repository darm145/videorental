package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.pdsw.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;

public interface ItemRentadoMapper {
	
public List<ItemRentado> getItemsRentados();
    
    public ItemRentado getItemRentado(@Param("id") int id);
    public ItemRentado saveItemRentado(@Param("ir") ItemRentado ir,@Param("docu") long docu);
    
    
		
	
}
