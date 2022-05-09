package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProductosDao;
import model.Producto;

public class ProductosServiceImpl implements ProductosService {
	ProductosDao productosDao;
	

	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public void altaProducto(Producto producto) {
		productosDao.save(producto);

	}

	@Override
	public boolean eliminarProducto(int id) {
		if(buscarProducto(id) != null) {
			productosDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Producto> todosProductos() {
		return this.productosDao.findAll();
	}

	@Override
	public List<Producto> productosSeccion(String seccion) {
		
		return productosDao.findAll()
		.stream()
		.filter(p->p.getSeccion().equals(seccion))
		.collect(Collectors.toList());
				
	}

	@Override
	public Producto buscarProducto(int id) {
		return this.productosDao.findById(id).orElse(null);
	}

}
