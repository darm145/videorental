package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   @Inject
   private ClienteDAO clienteDAO;
   @Inject
   private ItemRentadoDAO itemRentadoDAO;
   @Inject
   private TipoItemDAO tipoItemDAO;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
	   return  (int) itemDAO.load(itemId).getTarifaxDia();
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.load((int) docu);
	   }
	   catch(org.apache.ibatis.exceptions.PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar el cliente "+docu,ex);
	   }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.load((int) idcliente).getRentados();
	   }
	   catch(org.apache.ibatis.exceptions.PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar el cliente "+idcliente,ex);
	   }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.clientes();
	   }
	   catch(org.apache.ibatis.exceptions.PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar los clientes ",ex);
	   }
	
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
	   
	  return itemDAO.consultarItemsDisponibles();
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
	   try {
		   Item it=itemDAO.load(iditem);
		   return it.getTarifaxDia()*(System.currentTimeMillis()-fechaDevolucion.getTime())/(24 * 60 * 60 * 1000);
	   }
	   catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar multa alquiler",ex);
       }
	   
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
	   try {
           return tipoItemDAO.load(id);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item "+id,ex);
       }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
	   try {
           return tipoItemDAO.getTiposItems();
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los tipos items",ex);
       }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   try {
		   Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, numdias); 
	        Date fin=(Date) cal.getTime();
           ItemRentado ir=new ItemRentado(1,item, date,fin);
           itemRentadoDAO.save(ir, docu);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al registrar alquiler",ex);
       }
       
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
	   try {
           clienteDAO.save(c);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al registrar el cliente",ex);
       }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
	   try {
           Item it=itemDAO.load(iditem);
           return it.getTarifaxDia()*numdias;
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar costo alquiler del item "+iditem,ex);
       }
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
	   try {
           itemDAO.updateTarifa(id, tarifa);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al actualizar la tarifa del item "+id,ex);
       }
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	   try {
           itemDAO.save(i);
       } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al registrar el Item",ex);
       }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}