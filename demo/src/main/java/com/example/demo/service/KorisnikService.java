/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Korisnik;
import com.example.demo.model.Proizvodjac;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import java.util.List;

/**
 *
 * @author HP
 */
public class KorisnikService {
    
     @PersistenceUnit
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRM");
    
    
    @PersistenceContext 
    private static EntityManager entityManager = factory.createEntityManager();
    
    public static List<Korisnik> get() {
        return entityManager
                .createQuery("SELECT korisnici FROM Korisnik korisnici", Korisnik.class)
                .getResultList();
    }
    
    public static Korisnik get(String id) {
        return entityManager.find(Korisnik.class, Integer.valueOf(id));
    }
    
    public static String delete(String id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        Korisnik forDelete = entityManager.find(Korisnik.class, Integer.valueOf(id));
        entityManager.remove(forDelete);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Korisnik obrisan!";
    }
    
    public static String update(Korisnik object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.merge(object);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Korisnik izmijenjen!";
    }
    
     public static String create(Korisnik object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.persist(object);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Korisnik kreiran!";
    } 
     
    public static String blokiraj(int id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        Korisnik unblocked = entityManager.find(Korisnik.class, Integer.valueOf(id));
        unblocked.setBlokiran(true);
        entityManager.merge(unblocked);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Korisnik " + id + " blokiran!";
    }
    
    public static String odblokiraj(int id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        Korisnik blocked = entityManager.find(Korisnik.class, Integer.valueOf(id));
        blocked.setBlokiran(false);
        entityManager.merge(blocked);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
         return "Korisnik " + id + " odblokiran!";
    }
    
}
