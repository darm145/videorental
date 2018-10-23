package edu.eci.pdsw.view;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

@SuppressWarnings("deprecation")
@ManagedBean(name = "alquilerBean")
@RequestScoped
public class AlquilerItemsBean {
	@ManagedProperty(value = "#{param.documento}")
	private long documento;
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
	
	
	
	public List<ItemRentado> getItems() throws Exception{
		try {
            return serviciosAlquiler.consultarItemsCliente(documento);
            
        } catch (Exception e) {
            throw e;
        }
		
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}

}
