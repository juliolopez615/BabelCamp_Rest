package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin("*")
@RestController
public class ProductosController {
	@Autowired 
	ProductosService service;
	
	@GetMapping(value = "Productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.productos();
	}
	
	@PutMapping(value = "ActualizarProducto/{codigoProducto}/{unidadesCompradas}",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@PathVariable("codigoProducto") int codigoProducto, 
			@PathVariable("unidadesCompradas") int unidadesCompradas) {
		return String.valueOf(service.actualizar(codigoProducto, unidadesCompradas));
	}
	
	@GetMapping(value = "Precio/{codigoProducto}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String precio(@PathVariable("codigoProducto") int codigoProducto) {
		return  String.valueOf(service.precio(codigoProducto));
	}
}
