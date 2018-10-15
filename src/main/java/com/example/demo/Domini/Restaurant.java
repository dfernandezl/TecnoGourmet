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

    public static class RestaurantBuilder{

        private final String nomRestaurant;
        private final String direccio;
        private final String poblacio;
        private final double puntuacio;
        private final String descripcio;
        private final long numTelefon;

        public RestaurantBuilder(String nomRestaurant, String direccio, String poblacio,
                                 double puntuacio, String descripcio, long numTelefon){
            this.nomRestaurant = nomRestaurant;
            this.direccio = direccio;
            this.poblacio = poblacio;
            this.puntuacio = puntuacio;
            this.descripcio = descripcio;
            this.numTelefon = numTelefon;
        }

        public Restaurant build(){
            return new Restaurant(this);
        }

    }
}
