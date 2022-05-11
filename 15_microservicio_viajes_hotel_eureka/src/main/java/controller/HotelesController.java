package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {
	@Autowired
	HotelesService service;
	
	@GetMapping(value="Hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelesDisponibles(){
		return service.findByDisponibilidad();
	}
	
	@GetMapping(value="Hotel/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel hotelesDisponibles(@PathVariable("nombre") String nombre){
		return service.findByNombre(nombre);
	}
}
