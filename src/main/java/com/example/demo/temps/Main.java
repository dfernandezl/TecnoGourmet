package com.example.demo.temps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	private double temp;
	private long pressure;
	private long humidity;
	private double temp_min;
	private double temp_max;
	
	public Main() {
		
	}
	public double getTemp() {
		return temp;
	}
	public long getPressure() {
		return pressure;
	}
	public long getHumidity() {
		return humidity;
	}
	public double getTemp_min() {
		return temp_min;
	}
	public double getTemp_max() {
		return temp_max;
	}
	public String toString() {
		return ""+(int)(temp-273)+"ºC";
	}
	
}
