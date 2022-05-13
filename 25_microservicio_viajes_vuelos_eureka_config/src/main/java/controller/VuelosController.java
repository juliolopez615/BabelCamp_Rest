package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VuelosService;

@CrossOrigin("*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;
	
	@GetMapping(value="Vuelos/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelosDisponibles(@PathVariable("plazas") int plazas){
		return service.disponibles(plazas);
	}
	
	@PutMapping(value="ActualizarVuelo/{idVuelo}/{plazas}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		return String.valueOf(service.actuaizarVuelo(idVuelo, plazas));
	}
}
