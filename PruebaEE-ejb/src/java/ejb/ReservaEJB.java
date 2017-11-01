/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import ejb.CiudadEJB;
import entidad.Cliente;
import entidad.Reserva;
import entidad.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class ReservaEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName= "PruebaEE-ejbPU" )
    private EntityManager em;
    
    
            
    public List<Reserva> obtenerReservas(){
        
       List<Reserva> ress=new ArrayList<Reserva>();
        Query q= em.createNamedQuery("Reserva.findAll");
        try {
            ress= q.getResultList();
        }
       catch(javax.persistence.NoResultException e){
          return null;   
       }
      return ress;  
    }
    
    public boolean eliminarVuelo(Vuelo v){
        
        try {
            em.remove(em.merge (v)); 
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
    public List<Vuelo> obtenerVuelos()
    {
     List<Vuelo> vues=new ArrayList<Vuelo>();
     Query q=em.createNamedQuery("Vuelo.findAll");
     try{
         vues=q.getResultList();
     }catch(javax.persistence.NoResultException e){
     
     return null;
     }
        return vues;
    }

}
