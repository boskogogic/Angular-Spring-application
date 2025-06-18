package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class ElektricniTrotinet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; 
    
    private String objectId;
    private String cijenaNabavke;
    
   
    @OneToOne
    @JoinColumn(name = "proizvodjac_id")
    private Proizvodjac proizvodjac;
    private String model;
    private String maksimalnaBrzina;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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
    public ElektricniTrotinet setSlika(String slika) {
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
     * @param iznajmljeno the iznajmljeno to set
     */
    public ElektricniTrotinet setIznajmljeno(boolean iznajmljeno) {
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
    public ElektricniTrotinet setKvarovi(List<Kvar> kvarovi) {
        this.kvarovi = kvarovi;
        return this;
    }

    /**
     * @return the id
     */
    public String getId() {
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
    public ElektricniTrotinet setCijenaNabavke(String cijenaNabavke) {
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
    public ElektricniTrotinet setProizvodjac(Proizvodjac proizvodjac) {
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
    public ElektricniTrotinet setModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * @return the autonomija
     */
    public String getMaksimalnaBrzina() {
        return maksimalnaBrzina;
    }

    /**
     * @param autonomija the autonomija to set
     */
    public ElektricniTrotinet setAutonomija(String maksimalnaBrzina) {
        this.maksimalnaBrzina = maksimalnaBrzina;
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
    public ElektricniTrotinet setObjectId(String objectId) {
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
    public ElektricniTrotinet setPokvaren(boolean pokvaren) {
        this.pokvaren = pokvaren;
        return this;
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
    public ElektricniTrotinet setCijenaIznajmljivanja(String cijenaIznajmljivanja) {
        this.cijenaIznajmljivanja = cijenaIznajmljivanja;
        return this;
    }
}