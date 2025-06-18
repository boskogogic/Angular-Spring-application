package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proizvodjac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String naziv; 
    private String drzava;
    private String adresa;
    private String telefon;
    private String fax;
    private String email;
    
    public Proizvodjac() {
            
    }

    public Proizvodjac(String naziv, String email) {
        this.naziv = naziv;
        this.email = email;
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public Proizvodjac setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    /**
     * @return the drzava
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * @param drzava the drzava to set
     */
    public Proizvodjac setDrzava(String drzava) {
        this.drzava = drzava;
        return this;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public Proizvodjac setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public Proizvodjac setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public Proizvodjac setFax(String fax) {
        this.fax = fax;
        return this;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public Proizvodjac setEmail(String email) {
        this.email = email;
        return this;
    }

 
}