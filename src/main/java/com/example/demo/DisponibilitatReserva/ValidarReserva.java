package com.example.demo.DisponibilitatReserva;

import com.example.demo.Domini.Reserva;
import com.example.demo.Persistence.RestaurantDAO;
import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ValidarReserva {


    private ReservaUseCases rsvUseCases;

    private RestaurantUseCases restDAO;

    public ValidarReserva(ReservaUseCases rsvUseCases,RestaurantUseCases restDAO){
        this.rsvUseCases=rsvUseCases;
        this.restDAO=restDAO;
    }



    public boolean suficientCapacitat(Reserva rsv){

        List<Reserva> var= rsvUseCases.capacitatReservada(rsv.getRestaurant(),rsv.getTorn(),rsv.getData_reserva());
        int capacitatsOcupades=0;

        for (Iterator<Reserva> i = var.iterator(); i.hasNext();) {
            Reserva item = i.next();
            capacitatsOcupades+=item.getComensals();
        }

        int aux=capacitatsOcupades+rsv.getComensals();
        int aux2= restDAO.findByName(rsv.getRestaurant()).getCapacitat();

        return aux<= aux2;
    }

    public boolean dataValida(String datS){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datA = dateFormat.format(date);

        if(Integer.parseInt(datS.substring(0,4))>=Integer.parseInt(datA.substring(0,4))){
            if(Integer.parseInt(datS.substring(5,7))>=Integer.parseInt(datA.substring(5,7))){
                if(Integer.parseInt(datS.substring(8))>Integer.parseInt(datA.substring(8))){
                    return true;
                }
            }
        }
        return false;
    }



}
