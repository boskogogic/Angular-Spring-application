package com.unibl.etf.model.korisnici;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Klijent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String korisnickoIme;
    private String password;

    private String ime;
    private String prezime;
    private String email;
    private String brojLicneKarte;
    private String brojPasosa;
    private String brojVozackeDozvole;
    private String brojTelefona;
    private String avatar;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nalog> nalozi;//underictional
    
    private boolean daLiJeBlokiran;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public Klijent setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public Klijent setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public Klijent setIme(String ime) {
        this.ime = ime;
        return this;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public Klijent setPrezime(String prezime) {
        this.prezime = prezime;
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
    public Klijent setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * @return the brojLicneKarte
     */
    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    /**
     * @param brojLicneKarte the brojLicneKarte to set
     */
    public Klijent setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
        return this;
    }

    /**
     * @return the brojPasosa
     */
    public String getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * @param brojPasosa the brojPasosa to set
     */
    public Klijent setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
        return this;
    }

    /**
     * @return the brojVozackeDozvole
     */
    public String getBrojVozackeDozvole() {
        return brojVozackeDozvole;
    }

    /**
     * @param brojVozackeDozvole the brojVozackeDozvole to set
     */
    public Klijent setBrojVozackeDozvole(String brojVozackeDozvole) {
        this.brojVozackeDozvole = brojVozackeDozvole;
        return this;
    }

    /**
     * @return the brojTelefona
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * @param brojTelefona the brojTelefona to set
     */
    public Klijent setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
        return this;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public Klijent setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * @return the daLiJeBlokiran
     */
    public boolean isDaLiJeBlokiran() {
        return daLiJeBlokiran;
    }

    /**
     * @param daLiJeBlokiran the daLiJeBlokiran to set
     */
    public Klijent setDaLiJeBlokiran(boolean daLiJeBlokiran) {
        this.daLiJeBlokiran = daLiJeBlokiran;
        return this;
    }
    
    
    
  
}