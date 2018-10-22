package edu.eci.pdsw.test;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import edu.eci.pdsw.samples.entities.TipoItem;
import static org.quicktheories.generators.SourceDSL.*;

public class TipoItemGenerator {
	public static Gen<TipoItem> tiposItem(){
		return ids().zip(descripcion(), (id,descripcion)-> new TipoItem(id,descripcion));
		
	}
	public static Gen<Integer> ids(){
		return integers().from(1).upTo(Integer.MAX_VALUE);
	}
	public static Gen<String> descripcion(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 200);
	}
}
