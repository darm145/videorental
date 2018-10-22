package edu.eci.pdsw.test;
import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import org.quicktheories.generators.SourceDSL;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;

import static org.quicktheories.generators.SourceDSL.*;

import java.util.Date;

public class ItemGenerator {
	
	// el zip toco recortarle la fecha, el genero y el formato debido a que el zip no aguantaba tantos parametros
	public static Gen<Item> items(){
		return tiposItem().zip(ids(),nombre(),descripcion(),tarifas(),(tipoItem,id,nombre,
				descripcion,tarifa)-> new Item(tipoItem,id,nombre,descripcion,null,tarifa,null,null));
	}
	public static Gen<TipoItem> tiposItem(){
		return TipoItemGenerator.tiposItem();
	}
	public static Gen<Integer> ids(){
		return integers().from(1).upTo(Integer.MAX_VALUE);
	}
	public static Gen<String> nombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(5, 18);
	}
	public static Gen<String> descripcion(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 200);
	}
	@SuppressWarnings("deprecation")
	public static Gen<Date> date(){
		return integers().between(1, 31).zip(integers().between(0, 11), integers().between(100,108), (dia, mes, año)  -> new Date(año, mes, dia));
	}
	public static Gen<Long> tarifas(){
		return longs().between(3000,10000);
	}
	public static Gen<String> formato(){
		return strings().basicLatinAlphabet().ofLengthBetween(3, 7);
	}
	public static Gen<String> genero(){
		return strings().basicLatinAlphabet().ofLengthBetween(5, 20);
	}


}
