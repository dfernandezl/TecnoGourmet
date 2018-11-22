package com.example.demo.Domini;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

	private String restaurant;
	private String userName;
	private String data_reserva;
	private int comensals;
	private int presentat;
	private int id_reserva;

	private static int generadorID=0;

	public Reserva(){

	}

	public Reserva(ReservaBuilder builder) {
		this.restaurant=builder.restaurant;
		this.userName=builder.userName;
		this.data_reserva=builder.data_reserva;
		this.comensals=builder.comensals;
		this.presentat=builder.presentat;
		Reserva.generadorID++;
		this.id_reserva= Reserva.generadorID;
	}


	public String getRestaurant(){
		return this.restaurant;
	}

	public void setRestaurant(String restaurant){
		this.restaurant=restaurant;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}

	public int getComensals() {
		return comensals;
	}

	public void setComensals(int comensals) {
		this.comensals = comensals;
	}

	public int getPresentat() {
		return presentat;
	}

	public void setPresentat(int presentat) {
		this.presentat = presentat;
	}

	public int getId_reserva() {
		return this.id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}


	@Override
	public String toString() {
		return "Reserva{" +
				"UserName='" + this.userName + '\'' +
				", Data de la reserva=" + this.data_reserva +
				", Comensals='" + this.comensals + '\'' +
				", reserva presentada =" + this.presentat +
				", id de la reserva ='" + this.id_reserva + '\'' +
				'}';
	}

	 public static class ReservaBuilder {

		 	private String restaurant;
		 	private String userName;
			private String data_reserva;
			private int comensals;
		 	private int presentat;


	        public ReservaBuilder() {
	        }

		 	public ReservaBuilder restaurant(String restaurant) {
			 	this.restaurant=restaurant;
			 	return this;
		 	}


			 public ReservaBuilder usuari(String userName) {
				 this.userName=userName;
				 return this;
			 }

			 public ReservaBuilder presentat(int presentat) {
				 this.presentat=presentat;
				 return this;
			 }

	        public ReservaBuilder data_reserva(String data_reserva) {
	            this.data_reserva=data_reserva;
	            return this;
	        }

	        public ReservaBuilder comensals(int comensals) {
	            this.comensals=comensals;
	            return this;
	        }


	        public Reserva build() {
	            return new Reserva(this);
	        }

	    }
}
