package com.example.demo.WebController;

import com.example.demo.Domini.*;
import com.example.demo.FiltreIndex.Filtre;
import com.example.demo.UseCases.ComentariUseCases;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import com.example.demo.temps.WeatherWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class GETWebController {

    private RestaurantUseCases restUsesCases;
    private UsuariUseCases usuUseCases;
    private ReservaUseCases rsvUseCases;
    private ComentariUseCases cmtUseCases;

    public GETWebController(RestaurantUseCases restUsesCases,UsuariUseCases usuUseCases,ReservaUseCases rsvUseCases,ComentariUseCases cmtUseCases) {
        this.restUsesCases = restUsesCases;
        this.usuUseCases=usuUseCases;
        this.rsvUseCases= rsvUseCases;
        this.cmtUseCases=cmtUseCases;
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
        List<Comentari> var= this.cmtUseCases.findByRestaurant(name);
        if(var!=null){
            model.addAttribute("ListComt",var);
        }
        model.addAttribute("coment",new Comentari());
        model.addAttribute("rest", rest);
        
        RestTemplate restTemplate = new RestTemplate();
        WeatherWeb temps = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=mataró&APPID=4b8f72e96311a02a4a1da7f3c0ea71cd", WeatherWeb.class);
        model.addAttribute("temp", temps.toString());
        
        return "showRestaurant";
    }

    //usuaris

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

    @GetMapping("/newReserva/{nom}")
    public String createReserva(@PathVariable String nom, Model model) {
        model.addAttribute("nom",nom);
        model.addAttribute("rsv", new Reserva());
        return "newReserva";
    }


    @GetMapping("/showRsv/{id_reserva}")
    public String showreserva(@PathVariable int id_reserva, Model model){
        Reserva rsv=this.rsvUseCases.findById(id_reserva);
        model.addAttribute("rsv",rsv);
        return "showReserva";
    }


    //TODO: ACTUALITZAR/MODIFICAR RESERVA


    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("restList",this.restUsesCases.findAll());
        model.addAttribute("p", new Filtre());
        
        RestTemplate restTemplate = new RestTemplate();
        WeatherWeb temps = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=mataró&APPID=4b8f72e96311a02a4a1da7f3c0ea71cd", WeatherWeb.class);
        model.addAttribute("temp", temps.toString());
        return "index";
    }


    //login

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usr", new Usuari());
        return "IniciSessio";
    }



    @GetMapping("/puntuacio/{valor}")
    public String showPuntuacio(@PathVariable double valor,Model model){
        model.addAttribute("restList",this.restUsesCases.findByPuntuacio(valor));
        model.addAttribute("p", new Filtre());
        return "index";
    }

    @GetMapping("/nom/{valor}")
    public String showNom(@PathVariable String valor,Model model){
        model.addAttribute("restList",this.restUsesCases.findByName(valor));
        model.addAttribute("p", new Filtre());
        return "index";
    }

    @GetMapping("/ciutat/{valor}")
    public String showCiutat(@PathVariable String valor,Model model){
        model.addAttribute("restList",this.restUsesCases.findByPoblacio(valor));
        model.addAttribute("p", new Filtre());
        return "index";
    }








}
