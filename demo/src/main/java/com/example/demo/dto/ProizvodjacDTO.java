/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

/**
 *
 * @author HP
 */
public class ProizvodjacDTO {
    private String id;
    
    private String adresa;
    
    private String naziv;
    
    private String email;
    
    private String drzava;
    
    private String fax;
    
    private String telefon;

    public ProizvodjacDTO() {
        
    }

    public ProizvodjacDTO(String id, String adresa, String email, String drzava, String fax, String telefon) {
        this.id = id;
        this.adresa = adresa;
        this.email = email;
        this.drzava = drzava;
        this.fax = fax;
        this.telefon = telefon;
    }
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public ProizvodjacDTO setId(String id) {
        this.id = id;
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
    public ProizvodjacDTO setAdresa(String adresa) {
        this.adresa = adresa;
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
    public ProizvodjacDTO setEmail(String email) {
        this.email = email;
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
    public ProizvodjacDTO setDrzava(String drzava) {
        this.drzava = drzava;
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
    public ProizvodjacDTO setFax(String fax) {
        this.fax = fax;
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
    public ProizvodjacDTO setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
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
    public ProizvodjacDTO setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }
    
    
}
