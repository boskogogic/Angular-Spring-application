/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.IznajmljivanjeDTO;
import com.example.demo.dto.KvarDTO;
import com.example.demo.dto.PrevoznoSredstvoDTO;
import com.example.demo.dto.ZaposleniDTO;
import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.ElektricniTrotinet;
import com.example.demo.model.Iznajmljivanje;
import com.example.demo.model.Kvar;
import com.example.demo.model.Proizvodjac;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class PrevoznaSredstvaService {
    
    @PersistenceUnit
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRM");
    
    @PersistenceContext 
    private static EntityManager entityManager = factory.createEntityManager();
    
    public static List<?> get(Class<?> clazz) {
        if (clazz.equals(Automobil.class)) {
            List<Automobil> automobili = entityManager
                .createQuery("SELECT automobili FROM Automobil automobili", Automobil.class)
                .getResultList();
            return automobili;
        } else if (clazz.equals(ElektricniBicikl.class)) {
            List<ElektricniBicikl> bicikli = entityManager
                .createQuery("SELECT bicikli FROM ElektricniBicikl bicikli", ElektricniBicikl.class)
                .getResultList();
            return bicikli;
        } else if (clazz.equals(ElektricniTrotinet.class)) {
            List<ElektricniTrotinet> trotineti = entityManager
                .createQuery("SELECT trotineti FROM ElektricniTrotinet trotineti", ElektricniTrotinet.class)
                .getResultList();
            return trotineti;
        } else {
            System.out.println("Not implemented for that type of class");
            return null;
        }
    }
    
    public static List<?> getPaging(Class<?> clazz, int page, int numberOfObjectsPerPage) {
        /*  Example of paging 
            List<Employee> employees = entityManager.createQuery(
		"select e " +
		"from Employee e ",
		Employee.class)
            .setFirstResult(Integer.valueOf(page)*2) //start from 0 
            .setMaxResults(2)
            .getResultList();*/ 
        if (clazz.equals(Automobil.class)) {
            List<Automobil> automobili = entityManager
                .createQuery("SELECT automobili FROM Automobil automobili", Automobil.class)
                .setFirstResult(page*numberOfObjectsPerPage)
                .setMaxResults(numberOfObjectsPerPage)
                .getResultList();
            return automobili;
        } else if (clazz.equals(ElektricniBicikl.class)) {
            List<ElektricniBicikl> bicikli = entityManager
                .createQuery("SELECT bicikli FROM ElektricniBicikl bicikli", ElektricniBicikl.class)
                .getResultList();
            return bicikli;
        } else if (clazz.equals(ElektricniTrotinet.class)) {
            List<ElektricniTrotinet> trotineti = entityManager
                .createQuery("SELECT trotineti FROM ElektricniTrotinet trotineti", ElektricniTrotinet.class)
                .getResultList();
            return trotineti;
        } else {
            System.out.println("Not implemented for that type of class");
            return null;
        }
    }
    
    
    
    
    public static Object get(Class<?> clazz, String id) {
        if (clazz.equals(Automobil.class)) {
           Automobil automobil = entityManager.find(Automobil.class, Integer.valueOf(id));
           return automobil;
        } else if (clazz.equals(ElektricniBicikl.class)) {
           ElektricniBicikl bicikl = entityManager.find(ElektricniBicikl.class, Integer.valueOf(id));
           return bicikl;
        } else if (clazz.equals(ElektricniTrotinet.class)) {
            ElektricniTrotinet trotinet = entityManager.find(ElektricniTrotinet.class, Integer.valueOf(id));
           return trotinet;
        } else {
            System.out.println("Not implemented for that type of class");
            return null;
        }
    }
    
     public static List<Iznajmljivanje> getIznajmljivanja() {
        List<Iznajmljivanje> iznajmljivanja = new ArrayList<>();
        entityManager.getTransaction().begin();
        iznajmljivanja = entityManager
                .createQuery("SELECT iznajmljivanja FROM Iznajmljivanje iznajmljivanja", Iznajmljivanje.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return iznajmljivanja;
    }
    
    public static String delete(Class<?> clazz, String id) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        if (clazz.equals(Automobil.class)) {
           Automobil forDelete = entityManager.find(Automobil.class, Integer.valueOf(id));
           entityManager.remove(forDelete);
        } else if (clazz.equals(ElektricniBicikl.class)) {
           ElektricniBicikl forDelete = entityManager.find(ElektricniBicikl.class, Integer.valueOf(id));
           entityManager.remove(forDelete);  
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           ElektricniTrotinet forDelete = entityManager.find(ElektricniTrotinet.class, Integer.valueOf(id));
           entityManager.remove(forDelete);
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat obrisan!";
    }
    
    public static String update(Class<?> clazz, Object object) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        if (clazz.equals(Automobil.class)) {
           Automobil updated = (Automobil)object;
           entityManager.merge(updated);
        } else if (clazz.equals(ElektricniBicikl.class)) {
           ElektricniBicikl updated = (ElektricniBicikl)object;
           entityManager.merge(updated);
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           ElektricniTrotinet updated = (ElektricniTrotinet)object;
           entityManager.merge(updated);
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat izmijenjen!";
    }
    
     public static String updateCijena(Class<?> clazz, String cijena) {
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        if (clazz.equals(Automobil.class)) {
           List<Automobil> automobili = (List<Automobil>)get(Automobil.class);
           automobili.forEach(item -> {
               item.setCijenaIznajmljivanja(cijena);
               entityManager.merge(item);
           });
        } else if (clazz.equals(ElektricniBicikl.class)) {
           List<ElektricniBicikl> bicikli = (List<ElektricniBicikl>)get(ElektricniBicikl.class);
           bicikli.forEach(item -> {
               item.setCijenaIznajmljivanja(cijena);
               entityManager.merge(item);
           });
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           List<ElektricniTrotinet> trotineti = (List<ElektricniTrotinet>)get(ElektricniTrotinet.class);
           trotineti.forEach(item -> {
               item.setCijenaIznajmljivanja(cijena);
               entityManager.merge(item);
           });
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat izmijenjen!";
    }
    
    public static String create(Class<?> clazz, PrevoznoSredstvoDTO object) {
        //System.out.println("Object proizvodjac " + object.getNazivP() + " " + object.getEmailP()); provjereno uredno procitane vrijednosti
        entityManager.getTransaction().begin();// sucessfully create objects after adding transaction lines
        if (clazz.equals(Automobil.class)) {
            Automobil forCreate = new Automobil()
                   .setObjectId(object.getObjectId())
                   .setCijenaNabavke(object.getCijenaNabavke())
                   .setDatumNabavke(object.getDatumNabavke())
                   .setModel(object.getModel());
            Proizvodjac proizvodjac = new Proizvodjac(
                       object.getNazivP(),
                       object.getEmailP());
            proizvodjac.setAdresa(null).setDrzava(null).setFax(null).setTelefon(null);
            Proizvodjac fromDatabase = daLiPostoji(proizvodjac);
            // ako ne postoji sacuvaj ga 
            if (fromDatabase == null) {
                entityManager.persist(proizvodjac);
                forCreate.setProizvodjac(proizvodjac);
            } else {
                forCreate.setProizvodjac(fromDatabase);
            }
           // i needed this line to be everything okay
           entityManager.persist(forCreate);
           
        } else if (clazz.equals(ElektricniBicikl.class)) {
           ElektricniBicikl forCreate = new ElektricniBicikl()
                   .setObjectId(object.getObjectId())
                   .setCijenaNabavke(object.getCijenaNabavke())
                   .setModel(object.getModel());
            Proizvodjac proizvodjac = new Proizvodjac(
                       object.getNazivP(),
                       object.getEmailP());
            proizvodjac.setAdresa(null).setDrzava(null).setFax(null).setTelefon(null);
            Proizvodjac fromDatabase = daLiPostoji(proizvodjac);
            // ako ne postoji sacuvaj ga 
            if (fromDatabase == null) {
                entityManager.persist(proizvodjac);
                forCreate.setProizvodjac(proizvodjac);
            } else {
                forCreate.setProizvodjac(fromDatabase);
            }
           entityManager.persist(forCreate);
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           ElektricniTrotinet forCreate = new ElektricniTrotinet()
                   .setObjectId(object.getObjectId())
                   .setCijenaNabavke(object.getCijenaNabavke())
                   .setModel(object.getModel());
            Proizvodjac proizvodjac = new Proizvodjac(
                       object.getNazivP(),
                       object.getEmailP());
            proizvodjac.setAdresa(null).setDrzava(null).setFax(null).setTelefon(null);
           Proizvodjac fromDatabase = daLiPostoji(proizvodjac);
            // ako ne postoji sacuvaj ga 
            if (fromDatabase == null) {
                entityManager.persist(proizvodjac);
                forCreate.setProizvodjac(proizvodjac);
            } else {
                forCreate.setProizvodjac(fromDatabase);
            }
            entityManager.persist(forCreate);
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat kreiran!";
    }
     
    public static String iznajmi(Class<?> clazz, IznajmljivanjeDTO iznajmi) {
        Iznajmljivanje iznajmljeno = new Iznajmljivanje()
                .setVrijeme(iznajmi.getVrijeme())
                .setDatum(iznajmi.getDatum())
                .setIdentifickacioniDokument(iznajmi.getIdentifikacioniDokument())
                .setTrenutnaLokacija(iznajmi.getTrenutnaLokacija())
                .setKonacnaLokacija(iznajmi.getKonacnaLokacija());
        entityManager.getTransaction().begin();
        if (clazz.equals(Automobil.class)) {
            Automobil automobil = entityManager.find(Automobil.class, Integer.valueOf(iznajmi.getVoziloID()));
            if (automobil.isIznajmljeno()) return "Automobil je vec iznajmljen!";
            automobil.getIznajmljivanja().add(iznajmljeno);
            entityManager.persist(automobil);   
        } else if (clazz.equals(ElektricniBicikl.class)) {
          ElektricniBicikl bicikl = entityManager.find(ElektricniBicikl.class, Integer.valueOf(iznajmi.getVoziloID()));
            if (bicikl.isIznajmljeno()) return "Bicikl je vec iznajmljen!";
            bicikl.getIznajmljivanja().add(iznajmljeno);
            entityManager.persist(bicikl);   
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           ElektricniTrotinet trotinet = entityManager.find(ElektricniTrotinet.class, Integer.valueOf(iznajmi.getVoziloID()));
           if (trotinet.isIznajmljeno()) return "Trotinet je vec iznajmljen!";
           trotinet.getIznajmljivanja().add(iznajmljeno);
           entityManager.persist(trotinet);
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat iznajmljen!";
     }
    
    public static String kvar(Class<?> clazz, KvarDTO object) {
        System.out.println("Object kvar " +object.getObjectId() + " " + object.getOpis() + " " + object.getVrijeme() + " " + object.getDatum()); //provjereno uredno procitane vrijednosti        
        Kvar kvar = new Kvar()
                .setOpis(object.getOpis())
                .setVrijeme(object.getVrijeme())
                .setDatum(object.getDatum());           
        entityManager.getTransaction().begin();
        if (clazz.equals(Automobil.class)) {
            //Automobil automobil = entityManager.find(Automobil.class, Integer.valueOf(object.getObjectId()));
            TypedQuery<Automobil> query = entityManager
                .createQuery("SELECT auto FROM Automobil auto "
                        + "WHERE auto.objectId = :objectId", Automobil.class);
            query.setParameter("objectId", object.getObjectId());
            Automobil automobil = query.getSingleResult();
            if (automobil.isPokvaren()) {
                entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
                return "Automobil je vec pokvaren!";
            }
            automobil.setPokvaren(true);
            automobil.getKvarovi().add(kvar);
            entityManager.persist(automobil);   
        } else if (clazz.equals(ElektricniBicikl.class)) {
            TypedQuery<ElektricniBicikl> query = entityManager
                .createQuery("SELECT bicikl FROM ElektricniBicikl bicikli"
                        + "WHERE bicikli.objectId = objectId", ElektricniBicikl.class);
            query.setParameter("objectId", object.getObjectId());
            ElektricniBicikl bicikl = query.getSingleResult();
            if (bicikl.isPokvaren()) {
                entityManager.getTransaction().commit();
                return "Bicikl je vec pokvaren!";
            }
            bicikl.setPokvaren(true);
            bicikl.getKvarovi().add(kvar); 
          entityManager.persist(bicikl);   
        } else if (clazz.equals(ElektricniTrotinet.class)) {
           TypedQuery<ElektricniTrotinet> query = entityManager
                   .createQuery("SELECT trotinet FROM ElektricniTrotinet trotineti"
                        + "WHERE trotineti.objectId = objectId", ElektricniTrotinet.class);
            query.setParameter("objectId", object.getObjectId());
            ElektricniTrotinet trotinet = query.getSingleResult();
            if (trotinet.isIznajmljeno()) {
                entityManager.getTransaction().commit();
                return "Trotinet je vec pokvaren!";
            }
            trotinet.setPokvaren(true);
            trotinet.getKvarovi().add(kvar);
            entityManager.persist(trotinet);
        } 
        entityManager.getTransaction().commit();// sucessfully create after adding transaction lines
        return "Objekat kreiran!";
     }
    
    private static Proizvodjac daLiPostoji(Proizvodjac proizvodjac) {
        List<Proizvodjac> proizvodjaci = ProizvodjacService.get();
        for (Proizvodjac item : proizvodjaci) {
            System.out.println("Proizvodjac.getNaziv() " + proizvodjac.getNaziv());
            System.out.println("Proizvodjac.getEmail() " + proizvodjac.getEmail());
            System.out.println("item.getNaziv() " + item.getNaziv());
            System.out.println("item.getEmail() " + item.getEmail());
           if (item.getNaziv().equals(proizvodjac.getNaziv()) 
                   && item.getEmail().equals(proizvodjac.getEmail())) return item;
        }
        return null;
    }
}
