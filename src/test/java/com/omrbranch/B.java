package com.omrbranch;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class B {
	private int id;
    private String flightName;
    @JsonProperty("Country") 
    private String country;
    @JsonProperty("Destinations") 
    private String destinations;
    @JsonProperty("URL") 
    private String uRL;
}

