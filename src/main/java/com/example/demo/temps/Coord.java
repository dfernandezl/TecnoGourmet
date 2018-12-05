package com.example.demo.temps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {
	private double lon;
	private double lat;
	
}
