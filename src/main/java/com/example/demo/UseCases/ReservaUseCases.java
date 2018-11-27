package com.example.demo.UseCases;


import com.example.demo.Domini.Reserva;
import com.example.demo.Domini.Usuari;
import com.example.demo.Persistence.ReservaDAO;
import com.example.demo.Persistence.UsuariDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reservaUseCases")
public class ReservaUseCases {


    private ReservaDAO rsvDAO;

    public ReservaUseCases(ReservaDAO rsvDAO) {
        this.rsvDAO = rsvDAO;
    }

    public void insert(Reserva reserva){
        rsvDAO.insert(reserva);
    }

    public void update(Reserva reserva){
        rsvDAO.update(reserva);
    }

    public List<Reserva> findAll() {
        return rsvDAO.findAll();
    }

    public Reserva findById(int id){return rsvDAO.findById(id);}

    public List<Reserva> capacitatReservada(String nom,int torn,String data){
        return rsvDAO.capacitatReservada(nom,torn,data);
    }

}
