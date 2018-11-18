package com.example.demo.WebController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


//@Controller
public class FileWebController {

    /*
    @RequestMapping(value="uploadImage", method=RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody String handleFileUpload(@RequestParam("fichero") MultipartFile file){
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("Imatges/"+name + ".png")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into Imatges/" + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
    */

    public static String handleFileUpload(@RequestParam("fichero") MultipartFile file){
        String name = file.getOriginalFilename();
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
