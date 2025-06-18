/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.unibl.etf.model.korisnici.Klijent;
import com.unibl.etf.model.korisnici.Nalog;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author HP
 */
@Entity
public class Korisnik {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String email;

        private String password;

        private String[] hash;

        private String role;

    
        private String korisnickoIme;
 
        private String ime;
        private String prezime;

        private String brojLicneKarte;
        private String brojPasosa;
        private String brojVozackeDozvole;
        private String brojTelefona;
        private String avatar;
        private boolean blokiran;

          /**
     * @return the id
     */
    public Integer getId() {
        return id;
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
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the hash
     */
    public String[] getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String[] hash) {
        this.hash = hash;
    }


    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
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
    public Korisnik setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
        return this;
    }



    /**
     * @param password the password to set
     */
    public Korisnik setPassword(String password) {
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
    public Korisnik setIme(String ime) {
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
    public Korisnik setPrezime(String prezime) {
        this.prezime = prezime;
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
    public Korisnik setBrojLicneKarte(String brojLicneKarte) {
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
    public Korisnik setBrojPasosa(String brojPasosa) {
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
    public Korisnik setBrojVozackeDozvole(String brojVozackeDozvole) {
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
    public Korisnik setBrojTelefona(String brojTelefona) {
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
    public Korisnik setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * @return the blokiran
     */
    public boolean isBlokiran() {
        return blokiran;
    }

    /**
     * @param blokiran the blokiran to set
     */
    public Korisnik setBlokiran(boolean blokiran) {
        this.blokiran = blokiran;
        return this;
    }
}
