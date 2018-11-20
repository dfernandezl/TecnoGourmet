package com.example.demo.WebController;

import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Restaurant;
import com.example.demo.Domini.Usuari;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GETWebController {

    private RestaurantUseCases restUsesCases;
    private UsuariUseCases usuUseCases;
    private ReservaUseCases rsvUseCases;

    public GETWebController(RestaurantUseCases restUsesCases,UsuariUseCases usuUseCases,ReservaUseCases rsvUseCases) {
        this.restUsesCases = restUsesCases;
        this.usuUseCases=usuUseCases;
        this.rsvUseCases= rsvUseCases;
    }

    //Restaurants

    @GetMapping("/newRestaurant")
    public String createRestaurant(Model model) {
        model.addAttribute("rest", new Restaurant());
        return "newRestaurant";
    }

    //TODO: UPDATE RESTAURANT


    @GetMapping("/showRest/{name}")
    public String showRest(@PathVariable String name, Model model) {
        Restaurant rest = restUsesCases.findByName(name);
        System.out.println("rest foto: " + rest.getFoto());
        model.addAttribute("rest", rest);
        return "showRestaurant";
    }


    @GetMapping("showRestaurantPoblacio/{poblacio}")
    public String showRestByPoblacio(@PathVariable String poblacio, Model model) {
        model.addAttribute("restList", restUsesCases.findByPoblacio(poblacio));
        return "showRestPoblacio";
    }


    @GetMapping("showRestaurantPuntuacio/{puntuacio}")
    public String showRestByPuntuacio(@PathVariable int puntuacio, Model model) {
        model.addAttribute("restList", restUsesCases.findByPuntuacio(puntuacio));
        return "showRestPuntuacio";
    }


    //usuaris

    @GetMapping("showUsers") //Nomes hauria de ser visible per administrador
    public String showUsers(Model model) {

        model.addAttribute("ListUsers", usuUseCases.findAll());
        return "showUsuaris";
    }

    @GetMapping("/newUsuari")
    public String createUsuari(Model model) {
        model.addAttribute("usr", new Usuari());
        return "newUsuari";
    }

    @GetMapping("/showUser/{name}")
    public String showUser(@PathVariable String name, Model model) {
        model.addAttribute("usr", this.usuUseCases.findByName(name));
        return "UsuariCreated";
    }


    //TODO: ACTUALITZAR USUARI


    //Reserves


    //TODO:CREAR-INSERIR RESERVA

    @GetMapping("/newReserva")
    public String createResrva(Model model) {
        model.addAttribute("rsv", new Reserva());
        return "newReserva";
    }


    @GetMapping("/showRsv/{id_reserva}")
    public String showreserva(@PathVariable int id_reserva, Model model){
        model.addAttribute("rsv",this.rsvUseCases.findById(id_reserva));
        return "showReserva";
    }
    

    //TODO: ACTUALITZAR/MODIFICAR RESERVA


    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("restList",this.restUsesCases.findAll());
        List<String> options= new ArrayList<>();
        options.add("Ciutat");
        options.add("Puntució");
        options.add("Nom");
        model.addAttribute("optionsList",options);

        return "index";
    }


    //login
/*
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usr", new Usuari());
        return "IniciSessio";
    }
*/

}
