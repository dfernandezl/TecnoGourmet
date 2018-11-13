package com.example.demo.WebController;

import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.StorageService;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class POSTWebController {


    private UsuariUseCases usuUseCases;
    private RestaurantUseCases restUseCases;
    private ReservaUseCases rsvUseCases;
    private StorageService storageService;


        public POSTWebController(UsuariUseCases usuUseCases, RestaurantUseCases rest,ReservaUseCases rsvUseCases) {
            this.usuUseCases = usuUseCases;
            this.restUseCases = rest;
            this.rsvUseCases=rsvUseCases;
        }


        @PostMapping("/newUsu")
        public String createClassroom(@Valid @ModelAttribute("usr") Usuari usr, Errors errors, Model model, RedirectAttributes redirectAttributes) {


            if (errors.hasErrors()) {
                model.addAttribute("usr", usr);

                return "newUsuari";
            }

            //System.out.println(usr);

            model.addAttribute("name", usr.getUserName());

            usuUseCases.insert(usr);

            redirectAttributes.addAttribute("name", usr.getUserName());

            return "redirect:/showUser/{name}";
        }

/*
    @PostMapping("/newResr")
    public String handleFileUpload(@Valid @ModelAttribute("rest") Restaurant rest, @RequestParam("file") MultipartFile file,Errors errors, Model model, RedirectAttributes redirectAttributes) {


        if (errors.hasErrors()) {
            model.addAttribute("rest", rest);

            return "newRest";
        }

        model.addAttribute("nom", rest.getNomRestaurant());

        storageService.store(file);
        restUseCases.insert(rest);
        redirectAttributes.addAttribute("nom", rest.getNomRestaurant());
        return "redirect:/showRest/{nom}";
    }
*/


    @PostMapping("/newResv")
    public String createReservation(@Valid @ModelAttribute("rsv") Reserva rsv, Errors errors, Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            model.addAttribute("rsv", rsv);

            return "newReserva";
        }

        model.addAttribute("id_reserva", rsv.getId_reserva());

        //System.out.println(rsv);

        rsvUseCases.insert(rsv);

        redirectAttributes.addAttribute("id_reserva", rsv.getId_reserva());

        return "redirect:/showRsv/{id_reserva}";
    }


    //PROVA

    @PostMapping("/newRest")
    public String saveDeal(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        if(!file.isEmpty()){
            try{

                byte[] bytes=file.getBytes();
                System.out.println("Byte Data :"+bytes);
                String fileName=file.getOriginalFilename();
                File newFile = new File("webapplication-beta/src/main/resources/static");

                if (!newFile.exists()){
                    newFile.mkdirs();
                }

                File serverFile = new File(newFile.getAbsolutePath()+File.separator+fileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();


            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return "redirect:viewDeals.html";
    }


    //Prova


    @PostMapping("/prova")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        System.out.println("TOT ha aant perfecte!!!");
        return "redirect:/";
    }




}
