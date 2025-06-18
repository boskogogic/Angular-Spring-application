package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Automobil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String objectId;
    private String datumNabavke; 
    private String cijenaNabavke;
    
    // Be ware -> Withotu CascadeType.ALL it didn't worked !
    // Cascade podrazumijeva sta ce se od operacija implicirati na povezane objekte
    // Npr. CascadeType.ALL znaci da ce sve operacije (persist,delete,update) biti preslikane i na vezne objekte
    // Npr kada zelimo obrisati Automobil -> Onda ce obrisati i povezanog proizvodjaca
    @ManyToOne(optional=false, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "proizvodjac_id")
    private Proizvodjac proizvodjac;//underictional
    
    private String model;
    
    private String opis;

//    Bidirectional @OneToMany(mappedBy = "automobil", fetch = FetchType.LAZY)
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Kvar> kvarovi;//underictional
    
    private boolean pokvaren;
    
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Iznajmljivanje> iznajmljivanja;//underictional
    
    private boolean iznajmljeno;
    
    private String slika;
    
    private String cijenaIznajmljivanja;
    
    public Automobil() {
        
    }

    public Automobil(String objectId, String naziv, String email, String model, String cijenaNabavke) {
        this.objectId = objectId;
        this.cijenaNabavke = cijenaNabavke;
        this.proizvodjac = new Proizvodjac(naziv,email);
        this.model = model;
        this.pokvaren = false;
        this.iznajmljeno = false;
    }

     /**
     * @return the slika
     */
    public String getSlika() {
        return slika;
    }

    /**
     * @param slika the slika to set
     */
    public Automobil setSlika(String slika) {
        this.slika = slika;
        return this;
    }
    
     /**
     * @return the iznajmljeno
     */
    public boolean isIznajmljeno() {
        return iznajmljeno;
    }

    /**
     * @param iznjamljeno the iznjamljeno to set
     */
    public Automobil setIznajmljeno(boolean iznajmljeno) {
        this.iznajmljeno = iznajmljeno;
        return this;
    }
    
     /**
     * @return the kvarovi
     */
    public List<Kvar> getKvarovi() {
        if(kvarovi == null) kvarovi = new ArrayList<>();
        return kvarovi;
    }

    /**
     * @param kvarovi the kvarovi to set
     */
    public Automobil setKvarovi(List<Kvar> kvarovi) {
        this.kvarovi = kvarovi;
        return this;
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
    public Automobil setDatumNabavke(String datumNabavke) {
        this.datumNabavke = datumNabavke;
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
    public Automobil setCijenaNabavke(String cijenaNabavke) {
        this.cijenaNabavke = cijenaNabavke;
        return this;
    }

    /**
     * @return the proizvodjac
     */
    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    /**
     * @param proizvodjac the proizvodjac to set
     */
    public Automobil setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
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
    public Automobil setModel(String model) {
        this.model = model;
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
    public Automobil setOpis(String opis) {
        this.opis = opis;
        return this;
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
    public Automobil setObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    /**
     * @return the pokvaren
     */
    public boolean isPokvaren() {
        return pokvaren;
    }

    /**
     * @param pokvaren the pokvaren to set
     */
    public void setPokvaren(boolean pokvaren) {
        this.pokvaren = pokvaren;
    }

    /**
     * @return the iznajmljivanja
     */
    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
    }

    /**
     * @return the cijenaIznajmljivanja
     */
    public String getCijenaIznajmljivanja() {
        return cijenaIznajmljivanja;
    }

    /**
     * @param cijenaIznajmljivanja the cijenaIznajmljivanja to set
     */
    public Automobil setCijenaIznajmljivanja(String cijenaIznajmljivanja) {
        this.cijenaIznajmljivanja = cijenaIznajmljivanja;
        return this;
    }

    
}