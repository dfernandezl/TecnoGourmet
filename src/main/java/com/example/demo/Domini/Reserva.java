package com.example.demo.Domini;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Reserva {

	//Falta atribut Restaurant
	private String userName;
	private String data_reserva;
	private int comensals;
	private int presentat;
	private int id_reserva;

	public Reserva(){

	}
	
	public Reserva(String usuari,String data_reserva, int comensals, int id_reserva) {
		this.userName=usuari;
		this.data_reserva=data_reserva;
		this.comensals=comensals;
		this.id_reserva=id_reserva;
	}

	public Reserva(ReservaBuilder builder) {
		this.userName=builder.userName;
		this.data_reserva=builder.data_reserva;
		this.comensals=builder.comensals;
		this.presentat=builder.presentat;
		this.id_reserva=builder.id_reserva;
	}


	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String usuari){
		this.userName=usuari;
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

	public int isPresentat() {
		return presentat;
	}

	public void setPresentat(int presentat) {
		this.presentat = presentat;
	}

	public int getId_reserva() {
		return id_reserva;
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

		 	private String userName;
			private String data_reserva;
			private int comensals;
			private int presentat;
			private int id_reserva;


	        public ReservaBuilder() {
	        }

		 	public ReservaBuilder usuari(String userName) {
			 	this.userName=userName;
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

	        public ReservaBuilder id_reserva(int id_reserva) {
	            this.id_reserva=id_reserva;
	            return this;
	        }
	        
	        public ReservaBuilder presentat(int presentat) {
	            this.presentat=presentat;
	            return this;
	        }

	        public Reserva build() {
	            return new Reserva(this);
	        }
	    }
}
