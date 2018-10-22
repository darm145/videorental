package edu.eci.pdsw.test;
import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;

import static org.quicktheories.generators.SourceDSL.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteGenerator {
	
	public static Gen<Cliente> Clientes(){
		return nombre().zip(documento(), telefono(), vetado(), rentados(),(nombre,documento,telefono,vetado,rentados)
				-> new Cliente(nombre,documento,telefono,null,null,vetado,new ArrayList<ItemRentado>(rentados)));
	}
	public static Gen<String> nombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(20, 40);
	}
	public static Gen<Long> documento(){
		return longs().between(100000000,999999999);
	}
	public static Gen<String> telefono(){
		return strings().numericBetween(1000000,9999999);
	}
	public static Gen<String> direccion(){
		return strings().basicLatinAlphabet().ofLengthBetween(20, 40);
	}
	public static Gen<String> email(){
		return strings().basicLatinAlphabet().ofLengthBetween(20, 40);
	}
	public static Gen<Boolean> vetado(){
		return booleans().all();
	}
	public static Gen<List<ItemRentado>> rentados(){
		return lists().of(ItemRentadoGenerator.itemsRentados()).ofSizeBetween(0,5);
	}
	
}
