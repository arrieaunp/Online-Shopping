/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aunchisachanatipakul
 */
public class ProductsTable {
    public static List<Products> findAllProduct(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Products> prodList = null;
        try{
            prodList = (List<Products>) em.createNamedQuery("Products.findAll").getResultList();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return prodList;
    }
    
    public static List<Products> getAllProduct(){
        List<Products> prodList = findAllProduct();
        List<Products> prod_con_List = new ArrayList<>();
        for(Products single_prod : prodList){
            prod_con_List.add(new Products(single_prod.getId(), single_prod.getMovie(), single_prod.getRating(), single_prod.getYearcreate(), single_prod.getPrice()));
        }
        return prod_con_List;
    }
    
    public static Products findProductByMovie(String movie){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Products prod = null;
        try{
            prod = (Products) em.createNamedQuery("Products.findByMovie").setParameter("movie", movie).getSingleResult();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return prod;
    }

}
