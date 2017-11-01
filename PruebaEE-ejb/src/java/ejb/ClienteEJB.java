/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
//import entidad.Ciudad;
import entidad.Cliente;
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
public class ClienteEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName="PruebaEE-ejbPU")
    private EntityManager em;
    
     public boolean crearcliente(Cliente c){
        System.out.println(c.getNombres());
        System.out.println(c.getApellidos());
        System.out.println(c.getIdentificacion());
        System.out.println(c.getLogin());
        System.out.println(c.getClave());
        
        try {
            em.persist(c);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
        public boolean editarCliente(Cliente c){
        System.out.println(c.getNombres());
        System.out.println(c.getApellidos());
        System.out.println(c.getTi());
        System.out.println(c.getIdentificacion());
        System.out.println(c.getLogin());
        System.out.println(c.getClave());
      
        try {
            em.merge(c);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
        public boolean eliminarCliente(Cliente c){
        System.out.println(c.getNombres());
        System.out.println(c.getApellidos());
        System.out.println(c.getTi());
        System.out.println(c.getIdentificacion());
        System.out.println(c.getLogin());
        System.out.println(c.getClave());
   
        try {
            em.remove(em.merge (c)); 
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
    public List<Cliente> obtenerClientes(){
        
        List<Cliente> cliens = new ArrayList<Cliente>();
        Query q = em.createNamedQuery("Cliente.findAll");
        try {
            cliens=q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return cliens;
    }

}

