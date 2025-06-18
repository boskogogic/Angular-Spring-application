/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.ProizvodjacDTO;
import com.example.demo.dto.ZaposleniDTO;
import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.Proizvodjac;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ProizvodjacService {
    
    @PersistenceUnit
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRM");
    
    
    @PersistenceContext 
    private static EntityManager entityManager = factory.createEntityManager();
    
    public static List<Proizvodjac> get() {
        return entityManager
                .createQuery("SELECT proizvodjaci FROM Proizvodjac proizvodjaci", Proizvodjac.class)
                .getResultList();
    }
    
    public static Proizvodjac get(String id) {
        return entityManager.find(Proizvodjac.class, Integer.valueOf(id));
    }
    
    public static String delete(String id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        Proizvodjac forDelete = entityManager.find(Proizvodjac.class, Integer.valueOf(id));
        entityManager.remove(forDelete);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat obrisan!";
    }
    
    public static String update(Proizvodjac object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.merge(object);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat izmijenjen!";
    }
    
     public static String create(ProizvodjacDTO object) {
         System.out.println(object.getNaziv() + object.getAdresa() + object.getDrzava() + object.getEmail()+ object.getFax()+object.getTelefon());
        Proizvodjac forCreate = new Proizvodjac()
                .setNaziv(object.getNaziv())
                .setAdresa(object.getAdresa())
                .setDrzava(object.getDrzava())
                .setEmail(object.getEmail())
                .setFax(object.getFax())
                .setTelefon(object.getTelefon());
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.persist(forCreate);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat kreiran!";
    } 
}
