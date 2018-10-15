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


    @Autowired
    private ReservaDAO rsvDAO;

    public void insert(Reserva reserva){
        rsvDAO.insert(reserva);
    }

    public void update(Reserva reserva){
        rsvDAO.update(reserva);
    }

    public List<Reserva> findAll() {
        return rsvDAO.findAll();
    }



}
