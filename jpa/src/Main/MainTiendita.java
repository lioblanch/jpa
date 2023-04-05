/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Entidades.Fabricante;
import Main.Entidades.Producto;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pc
 */
public class MainTiendita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienditapu");
        EntityManager em = emf.createEntityManager();
        try{
            Fabricante fabricante1 = new Fabricante();
            fabricante1.setId(UUID.randomUUID().toString());
            fabricante1.setCodigo(1);
            fabricante1.setNombre("Asus");
            fabricante1.setPrecio(2000);
            
            
            em.getTransaction().begin();
            em.persist(fabricante1);
            em.getTransaction().commit();
            
            Fabricante fabricante2 = new Fabricante();
            fabricante2.setId(UUID.randomUUID().toString());
            fabricante2.setCodigo(2);
            fabricante2.setNombre("Lenovo");
            fabricante2.setPrecio(1000);
            
            
            Producto producto1 = new Producto();
            producto1.setId(UUID.randomUUID().toString());
            producto1.setMarca(fabricante1.getNombre());
            producto1.setPrecio(20000);
            producto1.setFabricante(fabricante1);
            
            em.getTransaction().begin();
            em.persist(producto1);
            em.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("Error de Sistema");
        }
        
    }
    
}
