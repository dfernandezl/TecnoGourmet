package com.example.demo.UploadImage;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileWeb {

    public static String handleFileUpload(@RequestParam("fichero") MultipartFile file, String name){
    	System.out.println(name);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/"+name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into src/main/resources/static" + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }



}
