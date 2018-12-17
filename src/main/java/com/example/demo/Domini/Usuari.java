package com.example.demo.Domini;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuari {


    @NotNull
    @Size(min = 3, message = "Name field must have at least 3 characters")
    private String userName;


    @NotNull
    @Size(min = 3, message = "Password field must have at least 3 characters")
    private String password;

    @NotNull
    private int punts;




    

    @NotNull
    private int reserves_no_presentades;


    public Usuari(){

    }

    public Usuari(String nom){
        this.userName=nom;
    }

    public Usuari(UsuariBuilder ub){

        this.userName=ub.userName;
        this.password=ub.password;
        this.punts=0;
        this.reserves_no_presentades=0;
    }


    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public int getPunts(){
        return this.punts;
    }

    public int getReserves_no_presentades(){
        return this.reserves_no_presentades;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }


    public void setPassword(String password){
        this.password=password;
    }

    public void setPunts(int punts){
        this.punts=punts;
    }

    public void setReserves_no_presentades(int reserves_no_presentades){
        this.reserves_no_presentades=reserves_no_presentades;
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "UserName='" + this.userName + '\'' +
                ", password=" + this.password +
                ", punts='" + this.punts + '\'' +
                ", reserves no presentades=" + this.reserves_no_presentades +
                '}';
    }


    public static class UsuariBuilder {


        public String userName;
        public String password;


        public UsuariBuilder() {
        }

        public UsuariBuilder userName(String name) {
                this.userName = name;
                return this;
            }

            public UsuariBuilder password(String password) {
                this.password = password;
            return this;
        }

        public Usuari build() {
            return new Usuari(this);
        }

    }

}
