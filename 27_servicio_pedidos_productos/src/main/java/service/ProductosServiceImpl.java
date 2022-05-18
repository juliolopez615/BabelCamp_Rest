package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	ProductosDao dao;
	
	public ProductosServiceImpl(@Autowired ProductosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Producto> productos() {
		return dao.findAll();
	}

	@Override
	public boolean actualizar(int codigoProducto, int unidadesCompradas) {
		Producto p = dao.findById(codigoProducto).orElse(null);
		if(p != null) {
			if(unidadesCompradas > p.getStock()) {
				return false;
			}else {
				p.setStock(p.getStock() - unidadesCompradas);
				dao.save(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public double precio(int codigoProducto) {
		Producto p = dao.findById(codigoProducto).orElse(null);
		if(p != null) {
			return p.getPrecioUnitario();
		}
		return -1;
	}

}
