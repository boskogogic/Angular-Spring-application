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
import java.util.List;

@Entity
public class ElektricniBicikl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String objectId;
    private String cijenaNabavke;
    
    @ManyToOne(optional=false, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "proizvodjac_id")
    private Proizvodjac proizvodjac;
    private String model;
    private String autonomija;// domet sa jednim punjenjem
    
//    @OneToMany(mappedBy = "bicikl", fetch = FetchType.LAZY)
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
     /**
     * @return the slika
     */
    public String getSlika() {
        return slika;
    }

    /**
     * @param slika the slika to set
     */
    public ElektricniBicikl setSlika(String slika) {
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
    public ElektricniBicikl setIznajamljeno(boolean iznajmljeno) {
        this.iznajmljeno = iznajmljeno;
        return this;
    }
    
     /**
     * @return the kvarovi
     */
    public List<Kvar> getKvarovi() {
        return kvarovi;
    }

    /**
     * @param kvarovi the kvarovi to set
     */
    public ElektricniBicikl setKvarovi(List<Kvar> kvarovi) {
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
     * @return the cijenaNabavke
     */
    public String getCijenaNabavke() {
        return cijenaNabavke;
    }

    /**
     * @param cijenaNabavke the cijenaNabavke to set
     */
    public ElektricniBicikl setCijenaNabavke(String cijenaNabavke) {
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
    public ElektricniBicikl setProizvodjac(Proizvodjac proizvodjac) {
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
    public ElektricniBicikl setModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * @return the autonomija
     */
    public String getAutonomija() {
        return autonomija;
    }

    /**
     * @param autonomija the autonomija to set
     */
    public ElektricniBicikl setAutonomija(String autonomija) {
        this.autonomija = autonomija;
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
    public ElektricniBicikl setObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

     /**
     * @return the iznajmljivanja
     */
    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
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
    public ElektricniBicikl setPokvaren(boolean pokvaren) {
        this.pokvaren = pokvaren;
        return this;
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
    public ElektricniBicikl setCijenaIznajmljivanja(String cijenaIznajmljivanja) {
        this.cijenaIznajmljivanja = cijenaIznajmljivanja;
        return this;
    }
       
}