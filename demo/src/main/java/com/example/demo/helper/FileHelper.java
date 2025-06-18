/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.helper;

import com.example.demo.dto.PrevoznoSredstvoDTO;
import com.example.demo.model.Automobil;
import com.example.demo.model.ElektricniBicikl;
import com.example.demo.model.ElektricniTrotinet;
import com.example.demo.service.PrevoznaSredstvaService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public class FileHelper {
    
    private final static String DELIMITER = ";";
 
    /* Object inside CSV and in frontend 
    
        export interface DialogAutomobil {
          objectId: number;
          nazivP: string;
          emailP: string;
          model: string;
          cijenaNabavke: string;
          datumNabavke: string;
        }
    
        CSV format wiil be OBJECT;objectId;nazivP;emailP;model;cijenaNabavke;
        OBJECT can be Automobil, Trotinet or Bicikl
    */

    public static String readFromCSV(MultipartFile  multipartFile) throws FileNotFoundException, IOException {
        System.out.println("readFomrCSV starts....");
        File file = convertMultiPartToFile(multipartFile);
        //System.out.println("Absoulute path ..."+ file.getAbsolutePath());
        //part of code for reading from csv file 
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        String[] tempArr;
        while ((line = reader.readLine()) != null) {
            tempArr = line.split(DELIMITER);
            String object = tempArr[0];
            String objectId = tempArr[1];
            String nazivP = tempArr[2];
            String emailP = tempArr[3];
            String model = tempArr[4];
            String cijenaNabavke = tempArr[5];
            System.out.println("DEBUG : object " + object);
            System.out.println("DEBUG : objectId " + objectId);
            System.out.println("DEBUG : nazivP " + nazivP);
            System.out.println("DEBUG : emailP " + emailP);
            System.out.println("DEBUG : model " + model);
            System.out.println("DEBUG : cijenaNabavke " + cijenaNabavke);

                 
            if ("Automobil".equals(object)) {
               PrevoznoSredstvoDTO auto = new PrevoznoSredstvoDTO(objectId, nazivP, emailP, model, cijenaNabavke);
               PrevoznaSredstvaService.create(Automobil.class, auto);
            } else if ("Bicikl".equals(object)) {
               PrevoznoSredstvoDTO bicikl = new PrevoznoSredstvoDTO(objectId, nazivP, emailP, model, cijenaNabavke);
               PrevoznaSredstvaService.create(ElektricniBicikl.class, bicikl);
            } else {
               PrevoznoSredstvoDTO trotinet = new PrevoznoSredstvoDTO(objectId, nazivP, emailP, model, cijenaNabavke);
               PrevoznaSredstvaService.create(ElektricniTrotinet.class, trotinet);
            }
            //String datumNabavke = tempArr[6];
        }
        reader.close();
        return "run: success eading from CSV file! Object created";
    }
    
//    private static File convertToFile(MultipartFile multipartFile) throws IOException {
//        // Specify the directory where the file will be stored
//        String uploadDir = "C:\\programiranje\\files";  // You can change this to any directory you prefer
//
//        // Create a path object to the upload directory
//        Path uploadPath = Paths.get(uploadDir);
//
//
//        // Get the original filename
//        String filename = multipartFile.getOriginalFilename();
//        
//        File destinationFile = new File(uploadPath.toFile(), filename);
//        System.out.println("destinatioNFile getAbsolutePath " + destinationFile.getAbsolutePath());
//        System.out.println("destinatioNFile getName " + destinationFile.getName());
//        System.out.println("destinatioNFile getPath " + destinationFile.getPath());
//        // Save the file to disk
//        multipartFile.transferTo(destinationFile);
//        
//        return destinationFile;
//    }
    
    private static File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

}
