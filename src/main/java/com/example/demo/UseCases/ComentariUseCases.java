package com.example.demo.UseCases;

import com.example.demo.Domini.Comentari;
import com.example.demo.Domini.Reserva;
import com.example.demo.Persistence.ComentariDAO;
import com.example.demo.Persistence.ReservaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("comentariUseCases")
public class ComentariUseCases {

    private ComentariDAO cmtDAO;

    public ComentariUseCases(ComentariDAO cmtDAO) {
        this.cmtDAO = cmtDAO;
    }

    public void insert(Comentari comentari){
        cmtDAO.insert(comentari);
    }

    public List<Comentari> findByRestaurant(String nomRestaurant){
        return cmtDAO.findByRestaurant(nomRestaurant);
    }

}
