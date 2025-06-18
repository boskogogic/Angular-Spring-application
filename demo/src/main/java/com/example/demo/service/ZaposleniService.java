/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;


import com.example.demo.model.Korisnik;
import com.example.demo.model.Proizvodjac;
import com.example.demo.model.Zaposleni;
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
public class ZaposleniService {
    
     @PersistenceUnit
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRM");
    
    
    @PersistenceContext 
    private static EntityManager entityManager = factory.createEntityManager();
    
    public static List<Zaposleni> get() {
        return entityManager
                .createQuery("SELECT zaposleni  FROM Zaposleni zaposleni", Zaposleni.class)
                .getResultList();

    }
    
    public static Zaposleni get(String id) {
        return entityManager.find(Zaposleni.class, Integer.valueOf(id));
    }
    
    public static String delete(String id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        Zaposleni forDelete = entityManager.find(Zaposleni.class, Integer.valueOf(id));
        entityManager.remove(forDelete);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Zaposleni obrisan!";
    }
    
    public static String update(Zaposleni object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.merge(object);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Zaposleni izmijenjen!";
    }
    
     public static String create(Zaposleni object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.persist(object);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Zaposleni kreiran!";
    } 
}
