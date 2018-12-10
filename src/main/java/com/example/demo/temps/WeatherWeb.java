package com.example.demo.temps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWeb {
	
	private Coord coord;
	private Weather wheather;
	private String base;
	private Main main;
	private long visibility;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private Sys sys;
	private long id;
	private String name;
	private long cod;
	
	public WeatherWeb() {
		
	}

	public Coord getCoord() {
		return coord;
	}

	public Weather getWheather() {
		return wheather;
	}

	public String getBase() {
		return base;
	}

	public Main getMain() {
		return main;
	}

	public long getVisibility() {
		return visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public long getDt() {
		return dt;
	}

	public Sys getSys() {
		return sys;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getCod() {
		return cod;
	}
	
	public String toString() {
		return this.main.toString();
	}
	
}
