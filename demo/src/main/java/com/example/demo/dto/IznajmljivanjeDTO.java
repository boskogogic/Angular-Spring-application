/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

/**
 *
 * @author HP
 */
public class IznajmljivanjeDTO {
    
    private String voziloID;
    
    private String datum;
    
    private String identifikacioniDokument;
    
    private String konacnaLokacija;
    
    private String trenutnaLokacija;
    
    private String vozackaDozvola;
    
    private String vrijeme;

    public IznajmljivanjeDTO() {
        
    }

    public IznajmljivanjeDTO(String voziloID, String datum, String identifikacioniDokument, String konacnaLokacija, String trenutnaLokacija, String vozackaDozvola, String vrijeme) {
        this.voziloID = voziloID;
        this.datum = datum;
        this.identifikacioniDokument = identifikacioniDokument;
        this.konacnaLokacija = konacnaLokacija;
        this.trenutnaLokacija = trenutnaLokacija;
        this.vozackaDozvola = vozackaDozvola;
        this.vrijeme = vrijeme;
    }

    /**
     * @return the automobilObjectID
     */
    public String getVoziloID() {
        return voziloID;
    }

    /**
     * @param automobilObjectID the automobilObjectID to set
     */
    public IznajmljivanjeDTO setVoziloID(String voziloID) {
        this.voziloID = voziloID;
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
    public IznajmljivanjeDTO setDatum(String datum) {
        this.datum = datum;
         return this;
    }

    /**
     * @return the identifikacioniDokument
     */
    public String getIdentifikacioniDokument() {
        return identifikacioniDokument;
    }

    /**
     * @param identifikacioniDokument the identifikacioniDokument to set
     */
    public IznajmljivanjeDTO setIdentifikacioniDokument(String identifikacioniDokument) {
        this.identifikacioniDokument = identifikacioniDokument;
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
    public IznajmljivanjeDTO setKonacnaLokacija(String konacnaLokacija) {
        this.konacnaLokacija = konacnaLokacija;
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
    public IznajmljivanjeDTO setTrenutnaLokacija(String trenutnaLokacija) {
        this.trenutnaLokacija = trenutnaLokacija;
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
    public IznajmljivanjeDTO setVozackaDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
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
    public IznajmljivanjeDTO setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
        return this;
    }
    
    
}
