package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Kvar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String opis;
    
    private String datum;
    
    private String vrijeme;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Automobil automobil;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    private ElektricniBicikl bicikl;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    private ElektricniTrotinet trotinet;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public Kvar setOpis(String opis) {
        this.opis = opis;
        return this;
    }

    /**
     * @return the datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public Kvar setDatum(String datum) {
        this.datum = datum;
        return this;
    }

    /**
     * @return the vrijeme
     */
    public String getVrijeme() {
        return vrijeme;
    }

    /**
     * @param vrijeme the vrijeme to set
     */
    public Kvar setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
        return this;
    }
    
    
    
    

  
}