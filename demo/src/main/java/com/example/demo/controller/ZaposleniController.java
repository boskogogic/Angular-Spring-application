/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;


import com.example.demo.model.Zaposleni;
import com.example.demo.service.ZaposleniService;
import java.util.List;
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

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/zaposleni")
public class ZaposleniController {
    
//    @Autowired
//    private final ProizvodjacService proizvodjacService;
    
    // Note -> You need to initialize autowierd variable
//    @Autowired
//    public ProizvodjacController(final ProizvodjacService proizvodjacService) {
//        this.proizvodjacService = proizvodjacService;
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getZaposlene")
    @ResponseStatus(HttpStatus.OK)
    public List<Zaposleni> getZaposlene() {
        return ZaposleniService.get();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getZaposlenog")
    @ResponseStatus(HttpStatus.OK)
    public Zaposleni getZaposlenog(@RequestParam("id") String id) {
        return ZaposleniService.get(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createZaposlenog")
    @ResponseStatus(HttpStatus.CREATED)
    public String createZaposlenog(@RequestBody Zaposleni zaposleni) {
        return ZaposleniService.create(zaposleni);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteZaposlenog")
    @ResponseStatus(HttpStatus.OK)
    public String deleteZaposlenog(@RequestParam("id") String id) {
        return ZaposleniService.delete(id);
    }
   
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateZaposlenog")
    @ResponseStatus(HttpStatus.OK)
    public String updateZaposlenog(@RequestBody Zaposleni zaposleni) {
        return ZaposleniService.update(zaposleni);
    }
}
