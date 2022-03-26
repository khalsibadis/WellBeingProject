package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.Domain.Publicity;
import com.esprit.pidevbackend.ServiceImp.IPublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


@RestController
@RequestMapping("/Publicity")
public class publicitycontroller {
    @Autowired
    IPublicityService publicityService;



    //http://localhost:8085/Offer/datePublicity/idPublicity/starDate/finDate
    @GetMapping("/datePublicity/{idPublicity}/{starDateOf}/{finDateOf}")
    @ResponseBody
    public boolean dateOffer(@PathVariable long idPublicity, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date starDateOf, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date finDateOf){
        return   publicityService.dateOffer(idPublicity,starDateOf,finDateOf);
    }


    @Value("${file.upload-dir}")
    String FILE_DIR;

    @PostMapping("/uploadImage")
    @ResponseBody
    public ResponseEntity<Object> uploadImage(@RequestParam MultipartFile imageFile, Model model , Publicity publicity) throws IOException {
    File myFile =new File(FILE_DIR + imageFile.getOriginalFilename());
    myFile.createNewFile();
    FileOutputStream fos = new FileOutputStream(myFile);
    fos.write(imageFile.getBytes());
    fos.close();
    return  new ResponseEntity<Object>("the File Uploaded Successfully", HttpStatus.OK);
    }

}

