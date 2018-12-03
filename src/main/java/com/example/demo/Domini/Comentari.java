package com.example.demo.Domini;

public class Comentari {

    private String usuari;
    private String text;
    private String restaurant;
    private int id;
    private static int generadorID=0;

    public Comentari(){

    }
/*
    public Comentari(String usuari, String text){
        this.usuari=usuari;
        this.text=text;
    }
*/
    public Comentari(int id,String usuari, String restaurant, String text){
        this.id=id;
        this.usuari=usuari;
        this.restaurant=restaurant;
        this.text=text;
    }


    public int generarID(){
        this.id=generadorID++;
        return this.id;
    }

    public String getUsuari(){
        return this.usuari;
    }

    public String getText(){
        return this.text;
    }

    public String getRestaurant(){
        return this.restaurant;
    }

    public void setUsuari(String usuari){
        this.usuari=usuari;
    }

    public void setText(String text){
        this.text=text;
    }

    public void setRestaurant(String restaurant){
        this.restaurant=restaurant;
    }

}
