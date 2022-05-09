package model;

import com.fasterxml.jackson.annotation.JsonAlias;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pais {
	@JsonAlias("name")
	private String pais;
	private String capital;
	@JsonAlias("population")
	private long habitantes;
	@JsonAlias("region")
	private String continente;
	@JsonAlias("flag")
	private String bandera;
	
	
}
