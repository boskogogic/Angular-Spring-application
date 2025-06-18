/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

/**
 *
 * @author HP
 */
public class KvarDTO {
    
    private String objectId;
    
    private String datum;

    private String opis;
    
    private String vrijeme;

    public KvarDTO() {
        
    }

    public KvarDTO(String objectId, String datum, String opis, String vrijeme) {
        this.objectId = objectId;
        this.datum = datum;
        this.opis = opis;
        this.vrijeme = vrijeme;
    }


    
    /**
     * @return the automobilObjectID
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId the automobilObjectID to set
     */
    public KvarDTO setObjectId(String objectId) {
        this.objectId = objectId;
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
    public KvarDTO setDatum(String datum) {
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
    public KvarDTO setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
        return this;
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
    public KvarDTO setOpis(String opis) {
        this.opis = opis;
        return this;
    }
    
    
}
