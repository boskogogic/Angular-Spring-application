package com.unibl.etf.model.korisnici;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Zaposleni {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String ime;
    private String prezime;
    
    private String rola;
    
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Nalog> nalog;//underictional

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public Zaposleni setIme(String ime) {
        this.ime = ime;
        return this;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public Zaposleni setPrezime(String prezime) {
        this.prezime = prezime;
        return this;
    }

    /**
     * @return the rola
     */
    public String getRola() {
        return rola;
    }

    /**
     * @param rola the rola to set
     */
    public Zaposleni setRola(String rola) {
        this.rola = rola;
        return this;
    }
    
    
    
    

  
}