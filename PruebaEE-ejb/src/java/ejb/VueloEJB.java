/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Vuelo;
import java.util.List;
import java.util.ArrayList;
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
public class VueloEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName="PruebaEE-ejbPU")
    private EntityManager em;
    
    public boolean crearvuelo(Vuelo v){
        //System.out.println();
        try {
            em.persist(v);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
    
    public boolean editarVuelo(Vuelo v){
   
        try {
            em.merge(v);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
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
