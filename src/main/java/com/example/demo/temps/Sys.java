package com.example.demo.temps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {
	private long type;
	private long id;
	private double message;
	private String country;
	private long sunrise;
	private long sunset;
	
}
