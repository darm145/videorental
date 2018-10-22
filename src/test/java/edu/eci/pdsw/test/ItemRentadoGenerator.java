package edu.eci.pdsw.test;
import static org.quicktheories.generators.SourceDSL.integers;

import java.sql.Date;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import org.quicktheories.generators.SourceDSL;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.Item;
public class ItemRentadoGenerator {
	public static Gen<ItemRentado> itemsRentados(){
		return ids().zip(item(),date(),date(),(id,item,iniciorenta,finrenta)-> new ItemRentado(id,item,iniciorenta,finrenta));
	}
	public static Gen<Integer> ids(){
		return integers().from(1).upTo(Integer.MAX_VALUE);
	}
	public static Gen<Item> item(){
		return ItemRentadoGenerator.item();
	}
	@SuppressWarnings("deprecation")
	public static Gen<Date> date(){
		return integers().between(1, 31).zip(integers().between(0, 11), integers().between(100,108), (dia, mes, año)  -> new Date(año, mes, dia));
	}

}
