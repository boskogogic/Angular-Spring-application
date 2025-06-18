package com.example.demo.service;

import com.example.demo.dto.ZaposleniDTO;
import com.example.demo.model.Zaposleni;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import java.util.List;
import org.springframework.stereotype.Service;



/**
 *
 * @author Bosko Gogic
 */

@Service
public class UserService {
    
    @PersistenceUnit
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRM");
    
    
    @PersistenceContext 
    private static EntityManager entityManager = factory.createEntityManager();
    
    public static String create(Zaposleni zaposleni) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        entityManager.persist(zaposleni);
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "User created";
    }
    
    public static List<Zaposleni> get(){
        List<Zaposleni> zaposleni = entityManager
                .createQuery("SELECT zaposleni FROM Zaposleni zaposleni", Zaposleni.class)
                .getResultList();
        return zaposleni;
    }
    
    public static boolean isExist(Zaposleni zaposleni) {
        //System.out.println("ID inside zaposleni object " + zaposleni.getId()); id = 0 that is the problem
        List<Zaposleni> sviZaposleni = get();
        if (sviZaposleni.isEmpty()) return false;
        for (Zaposleni item : sviZaposleni) { 
            if ( zaposleni.getUsername().equals(item.getUsername()) &&
                    zaposleni.getPassword().equals(item.getPassword()) &&
                    zaposleni.getRole().equals(item.getRole())) return true;
        }
        return false;
    }
}
