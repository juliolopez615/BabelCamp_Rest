package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Hotel;
import service.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {
	@Autowired
	HotelesService service;
	
	
	@ApiOperation(value="Devuelve los hoteles disponibles")
	@GetMapping(value="Hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelesDisponibles(){
		return service.findByDisponibilidad();
	}
	
	@ApiOperation(value="Devuelve los datos del hotel cuyo nombre recibe en url")
	@GetMapping(value="Hotel/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel hotelesDisponibles(@ApiParam(value="Nombre del hotel a buscar")
	@PathVariable("nombre") String nombre){
		return service.findByNombre(nombre);
	}
}
