/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.IznajmljivanjeDTO;
import com.example.demo.dto.KvarDTO;
import com.example.demo.dto.PrevoznoSredstvoDTO;
import com.example.demo.helper.FileHelper;
import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.ElektricniTrotinet;
import com.example.demo.model.Iznajmljivanje;
import com.example.demo.service.PrevoznaSredstvaService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Bosko Gogic
 */
@RestController
@RequestMapping("/prevoznasredstva")
public class PrevoznaSredstvaController {
    
    @Autowired
    private final PrevoznaSredstvaService prevoznaSredstvaService;
    
    // Note -> You need to initialize autowierd variable
    @Autowired
    public PrevoznaSredstvaController(final PrevoznaSredstvaService prevoznaSredstvaService) {
        this.prevoznaSredstvaService = prevoznaSredstvaService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestParam MultipartFile  file) {
        System.out.println("File upload starts....");
        System.out.println("File name is " + file.getName());
        try {
            // need to parse CSV file
            return FileHelper.readFromCSV(file);
        } catch (IOException ex) {
            Logger.getLogger(PrevoznaSredstvaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PrevoznaSredstvaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Not readed from CSV File!";
    }
    
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/uploadAutomobil")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void uploadAutomobil(@RequestParam MultipartFile file) {
//        System.out.println("File is created");
//        System.out.println("File name is " + file.getName());
//        System.out.println("File Origin name is " + file.getOriginalFilename());
//        System.out.println("File content type" + file.getContentType());
//        // need to parse CSV file
//    }
//    
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/uploadBicikl")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void uploadBicikl(@RequestParam MultipartFile file) {
//        System.out.println("File is created");
//        System.out.println("File name is " + file.getName());
//        System.out.println("File Origin name is " + file.getOriginalFilename());
//        System.out.println("File content type" + file.getContentType());
//        // need to parse CSV file
//    }
//    
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping("/uploadTrotinet")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void uploadTrotinet(@RequestParam MultipartFile file) {
//        System.out.println("File is created");
//        System.out.println("File name is " + file.getName());
//        System.out.println("File Origin name is " + file.getOriginalFilename());
//        System.out.println("File content type" + file.getContentType());
//        // need to parse CSV file
//    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAutomobili")
    @ResponseStatus(HttpStatus.OK)
    public List<Automobil> getAutomobili() {
        return (List<Automobil>)PrevoznaSredstvaService.get(Automobil.class);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAutomobiliPaging")
    @ResponseStatus(HttpStatus.OK)
    public List<Automobil> getAutomobiliPaging(@RequestParam("stranica") int page, @RequestParam("brojObjekata") int brojObjekata) {
        System.out.println("getAutomobiliPagin starts..... stranica " + page + " brojObjekata" + brojObjekata);
        return (List<Automobil>)PrevoznaSredstvaService.getPaging(Automobil.class, page, brojObjekata);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAutomobil")
    @ResponseStatus(HttpStatus.OK)
    public Automobil getAutomobil(@RequestParam("id") String id) {
       return (Automobil)PrevoznaSredstvaService.get(Automobil.class, id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBicikli")
    @ResponseStatus(HttpStatus.OK)
    public List<ElektricniBicikl> getBicikli() {
        return (List<ElektricniBicikl>)PrevoznaSredstvaService.get(ElektricniBicikl.class);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBicikl")
    @ResponseStatus(HttpStatus.OK)
    public ElektricniBicikl getBicikl(@RequestParam("id") String id) {
        return (ElektricniBicikl)PrevoznaSredstvaService.get(ElektricniBicikl.class, id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTrotineti")
    @ResponseStatus(HttpStatus.OK)
    public List<ElektricniTrotinet> getTrotineti() {
        return (List<ElektricniTrotinet>)PrevoznaSredstvaService.get(ElektricniTrotinet.class);
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTrotinet")
    @ResponseStatus(HttpStatus.OK)
    public ElektricniTrotinet getTrotinet(@RequestParam("id") String id) {
         return (ElektricniTrotinet)PrevoznaSredstvaService.get(ElektricniTrotinet.class, id);
    }
    
    // NOTE -> INside POST MAPPING you need to have @RequestBody parameter
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createAutomobil")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAutomobil(@RequestBody PrevoznoSredstvoDTO automobil) {
        return PrevoznaSredstvaService.create(Automobil.class, automobil);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createBicikl")
    @ResponseStatus(HttpStatus.CREATED)
    public String createBicikl(@RequestBody PrevoznoSredstvoDTO bicikl) {
        return PrevoznaSredstvaService.create(ElektricniBicikl.class, bicikl);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createTrotinet")
    @ResponseStatus(HttpStatus.CREATED)
    public String createTrotinet(@RequestBody PrevoznoSredstvoDTO trotinet) {
        return PrevoznaSredstvaService.create(ElektricniTrotinet.class, trotinet);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteAutomobil")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAutomobil(@RequestParam("id") String id) {
        System.out.println("deleteAutomobil starts.... " + id);
        return PrevoznaSredstvaService.delete(Automobil.class, id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteBicikl")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBicikl(@RequestParam("id") String id) {
        return PrevoznaSredstvaService.delete(ElektricniBicikl.class, id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteTrotinet")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTrotinet(@RequestParam("id") String id) {
        return PrevoznaSredstvaService.delete(ElektricniTrotinet.class, id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateAutomobil")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateAutomobil(@RequestParam Automobil automobil) {
        return PrevoznaSredstvaService.update(Automobil.class, automobil);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateBicikl")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateBicikl(@RequestParam ElektricniBicikl bicikl) {
        return PrevoznaSredstvaService.update(ElektricniBicikl.class, bicikl);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateTrotinet")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateTrotinet(@RequestParam ElektricniTrotinet trotinet) {
        return PrevoznaSredstvaService.update(ElektricniTrotinet.class, trotinet);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/iznajmiAutomobil")
    @ResponseStatus(HttpStatus.OK)
    public String iznajmiAutomobil(@RequestParam IznajmljivanjeDTO object) {
       return PrevoznaSredstvaService.iznajmi(Automobil.class, object);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createKvarBicikla")
    @ResponseStatus(HttpStatus.OK)
    public String createKvarBicikla(@RequestBody KvarDTO object) {
       return PrevoznaSredstvaService.kvar(ElektricniBicikl.class, object);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createKvarTrotineta")
    @ResponseStatus(HttpStatus.OK)
    public String createKvarTrotineta(@RequestBody KvarDTO object) {
       return PrevoznaSredstvaService.kvar(ElektricniTrotinet.class, object);
    }
    
    /*  ANOMALIJA slanja izmedju frontend i backend dijela aplikacija
    
        Create -> sa frontenda dolazi objekat tipa automobil : { naziv:"audi" ....} 
                  na backendu se prima kao @RequestBody DTO automobil -> Prolazi normalno jer je istog naziva
        Create -> sa frontenda dolazi objekat kvar : {opis: "povkaren motor" .... } 
                  na backendu se prima kao @RequestBody DTO object -> GRESKA ne cita ga dobro jer nije isti naziv!
    */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createKvarAutomobila")
    @ResponseStatus(HttpStatus.OK)
    public String createKvarAutomobila(@RequestBody KvarDTO object) {
       System.out.println("Object kvar " +object.getObjectId() + " " + object.getOpis() + " " + object.getVrijeme() + " " + object.getDatum()); //provjereno uredno procitane vrijednosti        
       return PrevoznaSredstvaService.kvar(Automobil.class, object);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getIznajmljivanja")
    @ResponseStatus(HttpStatus.OK)
    public List<Iznajmljivanje> getIznajmljivanja() {
       return PrevoznaSredstvaService.getIznajmljivanja();
    }
    
    // put mapping only works with RequestBody parameter
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCijenaAutomobila")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCijenaAutomobila(@RequestBody String cijena) {
        return PrevoznaSredstvaService.updateCijena(Automobil.class, cijena);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCijenaBicikla")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCijenaBicikla(@RequestBody String cijena) {
        return PrevoznaSredstvaService.updateCijena(ElektricniBicikl.class, cijena);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCijenaTrotineta")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCijenaTrotineta(@RequestBody String cijena) {
        return PrevoznaSredstvaService.updateCijena(ElektricniTrotinet.class, cijena);
    }
}
