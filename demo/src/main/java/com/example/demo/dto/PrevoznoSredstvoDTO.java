/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

/**
 *
 * @author HP
 */

/*
    ANGULAR object for mapping

    objectId: number;
    nazivP: string;
    emailP: string;
    model: string;
    cijenaNabavke: string;
    datumNabavke: string;
}
*/
public class PrevoznoSredstvoDTO {
    
    private String objectId;
    private String nazivP;
    private String emailP;
    private String model;
    private String cijenaNabavke;
    private String datumNabavke;

    public PrevoznoSredstvoDTO() {
        
    }
    
     public PrevoznoSredstvoDTO(String objectId, String nazivP, String emailP, String model, String cijenaNabavke) {
        this.objectId = objectId;
        this.nazivP = nazivP;
        this.emailP = emailP;
        this.model = model;
        this.cijenaNabavke = cijenaNabavke;
    }

    public PrevoznoSredstvoDTO(String objectId, String nazivP, String emailP, String model, String cijenaNabavke, String datumNabavke) {
        this.objectId = objectId;
        this.nazivP = nazivP;
        this.emailP = emailP;
        this.model = model;
        this.cijenaNabavke = cijenaNabavke;
        this.datumNabavke = datumNabavke;
    }

    /**
     * @return the objectId
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId the objectId to set
     */
    public PrevoznoSredstvoDTO setObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    /**
     * @return the nazivP
     */
    public String getNazivP() {
        return nazivP;
    }

    /**
     * @param nazivP the nazivP to set
     */
    public PrevoznoSredstvoDTO setNazivP(String nazivP) {
        this.nazivP = nazivP;
        return this;
    }

    /**
     * @return the emailP
     */
    public String getEmailP() {
        return emailP;
    }

    /**
     * @param emailP the emailP to set
     */
    public PrevoznoSredstvoDTO setEmailP(String emailP) {
        this.emailP = emailP;
        return this;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public PrevoznoSredstvoDTO setModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * @return the cijenaNabavke
     */
    public String getCijenaNabavke() {
        return cijenaNabavke;
    }

    /**
     * @param cijenaNabavke the cijenaNabavke to set
     */
    public PrevoznoSredstvoDTO setCijenaNabavke(String cijenaNabavke) {
        this.cijenaNabavke = cijenaNabavke;
        return this;
    }

    /**
     * @return the datumNabavke
     */
    public String getDatumNabavke() {
        return datumNabavke;
    }

    /**
     * @param datumNabavke the datumNabavke to set
     */
    public PrevoznoSredstvoDTO setDatumNabavke(String datumNabavke) {
        this.datumNabavke = datumNabavke;
        return this;
    }
    
    
}
