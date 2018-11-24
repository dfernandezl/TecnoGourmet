package com.example.demo.FiltreIndex;

public class Filtre {

    String opcio;
    String valor;


    public Filtre(){

    }

    public Filtre(String opcio, String valor){
        this.opcio=opcio;
        this.valor=valor;
    }


    public String getOpcio(){
        return this.opcio;
    }

    public String getValor(){
        return this.valor;
    }

    public void setOpcio(String opcio){
        this.opcio=opcio;
    }

    public void setValor(String valor){
        this.valor=valor;
    }



}
