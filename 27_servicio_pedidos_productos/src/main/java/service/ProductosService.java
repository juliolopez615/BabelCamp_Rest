package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	public List<Producto> productos();
	
	public boolean actualizar(int codigoProducto, int unidadesCompradas);
	
	public double precio(int codigoProducto);
}
