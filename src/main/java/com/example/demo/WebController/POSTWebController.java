package com.example.demo.WebController;

import com.example.demo.Domini.*;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class POSTWebController {


    private UsuariUseCases usuUseCases;
    private RestaurantUseCases restUseCases;
    private ReservaUseCases rsvUseCases;


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

            model.addAttribute("name", usr.getUserName());

            usuUseCases.insert(usr);

            redirectAttributes.addAttribute("name", usr.getUserName());

            return "redirect:/showUser/{name}";
        }

    @PostMapping("/newResv")
    public String createReservation(@Valid @ModelAttribute("rsv") Reserva rsv, Errors errors, Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            model.addAttribute("rsv", rsv);

            return "newReserva";
        }

        model.addAttribute("id_reserva", rsv.getId_reserva());

        rsvUseCases.insert(rsv);

        redirectAttributes.addAttribute("id_reserva", rsv.getId_reserva());

        return "redirect:/showRsv/{id_reserva}";
    }


    @RequestMapping(value="/newRest", method=RequestMethod.POST, consumes = "multipart/form-data")
    public String handleFileUpload(@Valid @ModelAttribute("rest") Restaurant rest,@RequestParam("fichero") MultipartFile file, Errors errors, Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            model.addAttribute("rest", rest);
            return "newRest";
        }


        model.addAttribute("name", rest.getNomRestaurant());

        FileWeb.handleFileUpload(file);
        rest.setFoto(file.getOriginalFilename()); //"src/main/resources/static"
        restUseCases.insert(rest);
        redirectAttributes.addAttribute("name", rest.getNomRestaurant());
        return "redirect:/showRest/{name}";
    }


    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("usr") Usuari usr, Errors errors, Model model, RedirectAttributes redirectAttributes) {

        LogIn usuValidar= new LogIn(usr.getUserName(),usr.getPassword());

        if(usuUseCases.validateUser(usuValidar)==null){
            return "loginNOValidated";
        }else{
            LogIn login= new LogIn(usr.getUserName(),usr.getPassword());
            return "loginValidated";
        }
    }

}


