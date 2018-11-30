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
	private int torn;

	private static int generadorID=0;

	public Reserva(){

	}

	public Reserva(int id_reserva,String userName,String restaurant,String data_reserva,int comensals,int presentat,int torn) {
		this.id_reserva=id_reserva;
		this.restaurant=restaurant;
		this.userName=userName;
		this.data_reserva=data_reserva;
		this.comensals=comensals;
		this.presentat=presentat;
		this.torn=torn;
	}

	public void generarId(){
		this.id_reserva=generadorID++;
	}


	public int getTorn(){
		return this.torn;
	}

	public void setTorn(int torn) {
		this.torn = torn;
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
}
