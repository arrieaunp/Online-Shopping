/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aunchisachanatipakul
 */
public class ShoppingcartTable {
    public static int calculatePrice(int quantity, int pricePerUnit){
        return quantity * pricePerUnit;
    }
    
    public static int findLastestCartID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        int lastestCartID = 0;
        List<Shoppingcart> shoppingCartList = null;
        try{
            shoppingCartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            for(Shoppingcart spCart : shoppingCartList){
                if(spCart.getShoppingcartPK().getCartId() > lastestCartID){
                    lastestCartID = spCart.getShoppingcartPK().getCartId();
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return lastestCartID;
    }
    
    public static void insertShoppingCart(Shoppingcart shoppingCart){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(shoppingCart);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
