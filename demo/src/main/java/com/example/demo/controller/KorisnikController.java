/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.ElektricniTrotinet;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Proizvodjac;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.PrevoznaSredstvaService;
import com.example.demo.service.ProizvodjacService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
    
//    @Autowired
//    private final ProizvodjacService proizvodjacService;
    
    // Note -> You need to initialize autowierd variable
//    @Autowired
//    public ProizvodjacController(final ProizvodjacService proizvodjacService) {
//        this.proizvodjacService = proizvodjacService;
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getKorisnici")
    @ResponseStatus(HttpStatus.OK)
    public List<Korisnik> getKorisnici() {
        return KorisnikService.get();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getKorisnik")
    @ResponseStatus(HttpStatus.OK)
    public Korisnik getKorisnik(@RequestParam("id") String id) {
        return KorisnikService.get(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createKorisnik")
    @ResponseStatus(HttpStatus.CREATED)
    public String createKorisnik(@RequestBody Korisnik korisnik) {
        return KorisnikService.create(korisnik);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteKorisnik")
    @ResponseStatus(HttpStatus.OK)
    public String deleteKorisnik(@RequestParam("id") String id) {
        return KorisnikService.delete(id);
    }
   
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateKorisnik")
    @ResponseStatus(HttpStatus.OK)
    public String updateKorisnik(@RequestBody Korisnik korisnik) {
        return KorisnikService.update(korisnik);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/blokiraj")
    @ResponseStatus(HttpStatus.OK)
    public String blokiraj(@RequestBody int id) {
        return KorisnikService.blokiraj(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/odblokiraj")
    @ResponseStatus(HttpStatus.OK)
    public String odblokiraj(@RequestBody int id) {
        return KorisnikService.odblokiraj(id);
    }
}
