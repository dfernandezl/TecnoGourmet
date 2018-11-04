package com.example.demo.WebController;

import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

            //System.out.println(usr);

            model.addAttribute("name", usr.getUserName());

            usuUseCases.insert(usr);

            redirectAttributes.addAttribute("name", usr.getUserName());

            return "redirect:/showUser/{name}";
        }


    @PostMapping("/newRest")
    public String createRestaurant(@Valid @ModelAttribute("rest") Restaurant rest, Errors errors, Model model, RedirectAttributes redirectAttributes) {


        if (errors.hasErrors()) {
            model.addAttribute("rest", rest);

            return "newUsuari";
        }

        model.addAttribute("nom", rest.getNomRestaurant());

        restUseCases.insert(rest);

        redirectAttributes.addAttribute("nom", rest.getNomRestaurant());

        return "redirect:/showRest/{nom}";
    }


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

}
