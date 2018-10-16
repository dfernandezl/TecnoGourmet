package com.example.demo.Domini;

public class Restaurant {

    private final String nomRestaurant;
    private final String direccio;
    private final String poblacio;
    private final double puntuacio;
    private final String descripcio;
    private final long numTelefon;

    private Restaurant(RestaurantBuilder builder) {
        nomRestaurant = builder.nomRestaurant;
        direccio = builder.direccio;
        poblacio = builder.poblacio;
        puntuacio = builder.puntuacio;
        descripcio = builder.descripcio;
        numTelefon = builder.numTelefon;

    }

    public String getNomRestaurant() {
        return nomRestaurant;
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


    public String toString(){
        return "nom: "+this.nomRestaurant+", direcció: "+this.direccio+", poblacio: "+ this.poblacio+", puntuacio: "+this.puntuacio+",descripcio: "+this.descripcio+", telefon"+numTelefon;
    }


    public static class RestaurantBuilder{

        private String nomRestaurant;
        private String direccio;
        private String poblacio;
        private double puntuacio;
        private String descripcio;
        private long numTelefon;


        public  RestaurantBuilder() {
        }


        public RestaurantBuilder nomRestaurant(String nomRestaurant) {
            this.nomRestaurant = nomRestaurant;
            return this;
        }

        public RestaurantBuilder direccio(String direccio) {
            this.direccio = direccio;
            return this;
        }

        public RestaurantBuilder poblacio(String poblacio) {
            this.poblacio = poblacio;
            return this;
        }

        public RestaurantBuilder puntuacio(double puntuacio) {
            this.puntuacio = puntuacio;
            return this;
        }

        public RestaurantBuilder descripcio(String descripcio) {
            this.descripcio = descripcio;
            return this;
        }

        public RestaurantBuilder numTelefon(long numTelefon) {
            this.numTelefon = numTelefon;
            return this;
        }

        public Restaurant build(){
            return new Restaurant(this);
        }

    }
}
