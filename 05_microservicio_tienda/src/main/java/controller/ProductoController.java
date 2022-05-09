package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;


@RestController
public class ProductoController {
	@Autowired
	ProductosService service;
	
	@PostMapping(value="Alta",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaProducto(@RequestBody Producto producto) {
		service.altaProducto(producto);
	}

	@DeleteMapping(value="Producto/{idProducto}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String eliminar(@PathVariable("idProducto") int idProducto) {
		return String.valueOf(service.eliminarProducto(idProducto));
	}
	@GetMapping(value="Productos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.todosProductos();
	}
	@GetMapping(value="ProductosSeccion/{seccion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productosSeccion(@PathVariable("seccion") String seccion){
		return service.productosSeccion(seccion);
	}
}
