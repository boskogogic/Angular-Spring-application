package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Iznajmljivanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String datum;
    private String vrijeme; 
    private String trenutnaLokacija;
    private String konacnaLokacija;//koordinate
    private String identifickacioniDokument;
    private String vozackaDozvola;
    
    //generisati racun za placanje u PDF formatu

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
    public Iznajmljivanje setDatum(String datum) {
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
    public Iznajmljivanje setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
        return this;
    }

    /**
     * @return the trenutnaLokacija
     */
    public String getTrenutnaLokacija() {
        return trenutnaLokacija;
    }

    /**
     * @param trenutnaLokacija the trenutnaLokacija to set
     */
    public Iznajmljivanje setTrenutnaLokacija(String trenutnaLokacija) {
        this.trenutnaLokacija = trenutnaLokacija;
        return this;
    }

    /**
     * @return the konacnaLokacija
     */
    public String getKonacnaLokacija() {
        return konacnaLokacija;
    }

    /**
     * @param konacnaLokacija the konacnaLokacija to set
     */
    public Iznajmljivanje setKonacnaLokacija(String konacnaLokacija) {
        this.konacnaLokacija = konacnaLokacija;
        return this;
    }

    /**
     * @return the identifickacioniDokument
     */
    public String getIdentifickacioniDokument() {
        return identifickacioniDokument;
    }

    /**
     * @param identifickacioniDokument the identifickacioniDokument to set
     */
    public Iznajmljivanje setIdentifickacioniDokument(String identifickacioniDokument) {
        this.identifickacioniDokument = identifickacioniDokument;
        return this;
    }

    /**
     * @return the vozackaDozvola
     */
    public String getVozackaDozvola() {
        return vozackaDozvola;
    }

    /**
     * @param vozackaDozvola the vozackaDozvola to set
     */
    public Iznajmljivanje setVozackaDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
        return this;
    }
    
    
}