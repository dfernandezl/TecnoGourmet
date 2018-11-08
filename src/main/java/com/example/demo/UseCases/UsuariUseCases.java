package com.example.demo.UseCases;

import com.example.demo.Domini.Usuari;
import com.example.demo.Persistence.UsuariDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("usuariUseCases")
public class UsuariUseCases {


    private UsuariDAO usuDAO;

    public UsuariUseCases(UsuariDAO usuDAO) {
        this.usuDAO = usuDAO;
    }



    public void insert(Usuari usuari){
            usuDAO.insert(usuari);
    }

    public void update(Usuari usuari){
        usuDAO.updatePassword(usuari);
    }

    public List<Usuari> findAll() {
        return usuDAO.findAll();
    }

    public Usuari findByName(String name) {return usuDAO.findByName(name);}

}
