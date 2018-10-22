package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("cliente") int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("id")int id, 
    		@Param("idit") int idit, 
    		@Param("fechainicio")Date fechainicio,
    		@Param("fechafin") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
    
    public void insertarCliente(@Param("cli")Cliente cl);

	public void vetarCliente(@Param("documento")long docu,@Param("estado") boolean estado);
    
}
