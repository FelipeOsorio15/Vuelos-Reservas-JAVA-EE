/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import entidad.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author pc
 */
@Stateless
@LocalBean
public class CiudadEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName= "PruebaEE-ejbPU" )
    private EntityManager em;
    

    
    public boolean crearciudad(Ciudad c){
        System.out.println(c.getNombre());
        try {
            em.persist(c);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
        public List<Ciudad> obtenerCiudades(){
        
       List<Ciudad> ciuds=new ArrayList<Ciudad>();
        Query q= em.createNamedQuery("Ciudad.findAll");
        try {
            ciuds= q.getResultList();
        }
       catch(javax.persistence.NoResultException e){
          return null;   
       }
      return ciuds;        
    }
    public boolean editarCiudad(Ciudad c){
        System.out.println(c.getNombre());
      
        try {
            em.merge(c);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
    public boolean eliminarCiudad(Ciudad c){
        System.out.println(c.getNombre());
   
        try {
            em.remove(em.merge (c)); 
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
        


}
