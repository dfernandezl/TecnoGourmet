package com.example.demo.WebController;

import com.example.demo.Domini.*;
import com.example.demo.FiltreIndex.Filtre;
import com.example.demo.UseCases.ComentariUseCases;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;
import com.example.demo.temps.WeatherWeb;


import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
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


    @GetMapping("/showRest/{name}/{nom}")
    public String showRest(@PathVariable String name,@PathVariable String nom, Model model) {
        if(nom.equalsIgnoreCase("null")){
            return "redirect:/login";
        }
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
        model.addAttribute("usr",new Usuari(nom));
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

    @GetMapping("/newReserva/{nom}/{usuari}")
    public String createReserva(@PathVariable String nom,@PathVariable String usuari,Model model) {
        model.addAttribute("nom",nom);
        model.addAttribute("rsv", new Reserva());
        model.addAttribute("usr",new Usuari(usuari));
        return "newReserva";
    }


    @GetMapping("/showRsv/{id_reserva}/{usuari}")
    public String showreserva(@PathVariable int id_reserva,@PathVariable String usuari, Model model){
        Reserva rsv=this.rsvUseCases.findById(id_reserva);
        model.addAttribute("rsv",rsv);
        model.addAttribute("usr",new Usuari(usuari));
        return "showReserva";
    }

    @GetMapping("/showReserves/{nomRest}")
    public String showReserves(@PathVariable String nomRest, Model model){
        model.addAttribute("rsvList", this.rsvUseCases.findByRest(nomRest));
        return "ReservesRest";
    }

    @GetMapping("/reservesUsu/{nomUsu}")
    public String showReservesUsu(@PathVariable String nomUsu, Model model){
        if(!nomUsu.equalsIgnoreCase("null")) {
            model.addAttribute("rsvListUsu", this.rsvUseCases.findByUsu(nomUsu));
            model.addAttribute("usr", new Usuari(nomUsu));
            return "ReservesUsu";
        }else{
            return "redirect:/login";
        }
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

    @GetMapping("/loginRest")
    public String loginRest(Model model) {
        model.addAttribute("rst", new Restaurant());
        return "IniciSessioRest";
    }



    @GetMapping("/puntuacio/{valor}/{usuari}")
    public String showPuntuacio(@PathVariable double valor,@PathVariable String usuari,Model model){
        model.addAttribute("restList",this.restUsesCases.findByPuntuacio(valor));
        model.addAttribute("p", new Filtre());
        model.addAttribute("usr",new Usuari(usuari));
        return "index";
    }

    @GetMapping("/nom/{valor}/{usuari}")
    public String showNom(@PathVariable String valor,@PathVariable String usuari,Model model){
        model.addAttribute("restList",this.restUsesCases.findByName(valor));
        model.addAttribute("p", new Filtre());
        model.addAttribute("usr",new Usuari(usuari));
        return "index";
    }

    @GetMapping("/ciutat/{valor}/{usuari}")
    public String showCiutat(@PathVariable String valor,@PathVariable String usuari,Model model){
        model.addAttribute("restList",this.restUsesCases.findByPoblacio(valor));
        model.addAttribute("p", new Filtre());
        model.addAttribute("usr",new Usuari(usuari));
        return "index";
    }




}
