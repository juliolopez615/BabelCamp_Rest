package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vuelo {
	private int idVuelo;
	private String company;
	private String fecha;
	private int precio;
	private int plazas;
}
