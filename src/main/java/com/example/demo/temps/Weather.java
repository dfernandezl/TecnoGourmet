package com.example.demo.temps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	private long id;
	private String main;
	private String description;
	private String icon;
	
}
