package edu.eci.pdsw.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;


@SuppressWarnings("deprecation")
@ManagedBean(name = "ClienteBean")
@SessionScoped
public class ClienteBean extends BasePageBean{
	private String nombre;
	private long documento;
	private String telefono;
    private String direccion;
    private String email;
	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
    public List<Cliente> getClientes() throws Exception{
        try {
            return serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler e) {
            
            throw e;
        }
        
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void registrar() throws ExcepcionServiciosAlquiler {
		Cliente c=new Cliente(nombre,documento,telefono,direccion,email);
		serviciosAlquiler.registrarCliente(c);
	}

}
