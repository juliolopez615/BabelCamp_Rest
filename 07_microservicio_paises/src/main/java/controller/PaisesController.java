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
import model.Pais;
import service.PaisesService;

@CrossOrigin("*")
@RestController
public class PaisesController {
	@Autowired
	PaisesService service;
	
	@ApiOperation(value="Devuelve los continentes de la lista de paises")
	@GetMapping(value="continentes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	@ApiOperation(value="Devuelve paises que existen por continente")
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente(@ApiParam(value="Nombre del continente")
	@PathVariable("continente") String continente){
		return service.paisesContinente(continente);
	}
	@ApiOperation(value="Devuelve la población de un continente")
	@GetMapping(value="poblacion/{continente}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionPais(@ApiParam(value="Nombre del continente")
	@PathVariable("continente") String continente){
		return String.valueOf(service.poblacionContinente(continente));
	}
}
