/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.ProizvodjacDTO;
import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.ElektricniTrotinet;
import com.example.demo.model.Proizvodjac;
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
@RequestMapping("/proizvodjac")
public class ProizvodjacController {
    
//    @Autowired
//    private final ProizvodjacService proizvodjacService;
    
    // Note -> You need to initialize autowierd variable
//    @Autowired
//    public ProizvodjacController(final ProizvodjacService proizvodjacService) {
//        this.proizvodjacService = proizvodjacService;
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getProizvodjaci")
    @ResponseStatus(HttpStatus.OK)
    public List<Proizvodjac> getProizvodjaci() {
        return ProizvodjacService.get();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getProizvodjac")
    @ResponseStatus(HttpStatus.OK)
    public Proizvodjac getProizvodjac(@RequestParam("id") String id) {
        return ProizvodjacService.get(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createProizvodjac")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProizvodjac(@RequestBody ProizvodjacDTO proizvodjac) {
        return ProizvodjacService.create(proizvodjac);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteProizvodjac")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProizvodjac(@RequestParam("id") String id) {
        // need to implement
        return ProizvodjacService.delete(id);
    }
   
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateProizvodjac")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateProizvodjac(@RequestBody Proizvodjac proizvodjac) {
        return ProizvodjacService.update(proizvodjac);
    }

}
