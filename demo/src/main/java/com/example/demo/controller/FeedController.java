/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/rssfeed")
public class FeedController {
    
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    public String getAdRssFeed() throws FeedException {
        
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_1.0");
        feed.setTitle("Internet programiranje");
        feed.setLink("http://localhost:8090/sportvision");
        feed.setDescription("Patike feed promotions");
        feed.setAuthor("Autor - Bosko Gogic");

        List<SyndEntry> entries = new ArrayList<>();

        // Example ad 1
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("SPORT VISION patike");
        entry.setLink("https://www.sportvision.ba/patike/za-muskarce+unisex/za-odrasle");
        entry.setPublishedDate(new Date());

        SyndContent description1 = new SyndContentImpl();
        description1.setType("text/html");
        description1.setValue("KUPITE PATIKE PO NAJPOVOLJNIJOJ CIJENI");
        entry.setDescription(description1);
        entries.add(entry);

        // Example ad 2
//        SyndEntry ad2 = new SyndEntryImpl();
//        ad2.setTitle("Buy 1 Get 1 Free: Sunglasses");
//        ad2.setLink("https://example.com/ads/sunglasses-bogo");
//        ad2.setPublishedDate(new Date());

//        SyndContent description2 = new SyndContentImpl();
//        description2.setType("text/plain");
//        description2.setValue("Stylish sunglasses - buy one, get one free until this weekend.");
//        ad2.setDescription(description2);
//        adEntries.add(ad2);

        feed.setEntries(entries);

        SyndFeedOutput output = new SyndFeedOutput();
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\programiranje\\files\\feed\\example.txt");
            output.output(feed, writer);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return writer.toString();
    }
    
    @GetMapping(value = "/getExistingFeed", produces = MediaType.APPLICATION_XML_VALUE)
    public String getExistingFeed() throws FeedException {

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null; 
        try {
           feed = input.build(new XmlReader(new File("C:\\programiranje\\files\\feed\\example.txt")));
        } catch (IOException ex) {
            Logger.getLogger(FeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<SyndEntry>feedEntries = feed.getEntries();
        return "Feed pronadjen " + feedEntries.get(0).getLink() + " " + feedEntries.get(0).getTitle() + " author " + feedEntries.get(0).getAuthor();
    }

}
