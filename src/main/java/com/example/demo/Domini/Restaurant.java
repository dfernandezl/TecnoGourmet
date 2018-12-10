package com.example.demo.Domini;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.File;

public class Restaurant {

    public String nomRestaurant;
    public String password;
    public String direccio;
    public String poblacio;
    public double puntuacio;
    public String descripcio;
    public long numTelefon;
    public  int capacitat;
    public int nVots;
    public  String foto;


    public Restaurant(){

    }

    public  Restaurant(String nomRestaurant,String password,String direccio,String poblacio,Double puntuacio,String descripcio,long numTelefon,int capacitat,String foto, int nVots) {
        this.nomRestaurant = nomRestaurant;
        this.password=password;
        this.direccio =direccio;
        this.poblacio = poblacio;
        this.puntuacio = puntuacio;
        this.descripcio = descripcio;
        this.numTelefon = numTelefon;
        this.capacitat= capacitat;
        this.foto=foto;
        this.nVots=nVots;
    }

    public int getnVots(){
        return this.nVots;
    }

    public String getFoto() { return foto;}

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDireccio() {
        return direccio;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public double getPuntuacio() {
        return puntuacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public long getNumTelefon() {
        return numTelefon;
    }

    public int getCapacitat() {
        return capacitat;
    }



    public void setnVots(int nVots){
        this.nVots=nVots;
    }

    public void setFoto(String foto){ this.foto=foto; }


    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant=nomRestaurant;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public void setDireccio(String direccio) {
        this.direccio=direccio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio=poblacio;
    }

    public void setPuntuacio(double puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setDescripcio(String descripcio){
        this.descripcio=descripcio;
    }

    public void setNumTelefon(long numTelefon ){
        this.numTelefon=numTelefon;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat=capacitat;
    }

    public String toString(){
        return "nom: "+this.nomRestaurant+", direcció: "+this.direccio+" capcitat:"+this.capacitat+", poblacio: "+ this.poblacio+", puntuacio: "+this.puntuacio+",descripcio: "+this.descripcio+", telefon: "+numTelefon+", foto:"+this.foto+",nVots:"+nVots;
    }


}
