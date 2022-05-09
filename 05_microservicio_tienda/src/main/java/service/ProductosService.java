package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	void altaProducto(Producto producto);
	boolean eliminarProducto(int id);
	Producto buscarProducto(int id);
	List <Producto> todosProductos();
	List <Producto> productosSeccion(String seccion);
}
