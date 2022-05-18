package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {
	RestTemplate template;
	PedidosDao dao;
	String urlBase="http://servicio-productos/producto/";
	
	
	public PedidosServiceImpl(@Autowired RestTemplate template, @Autowired PedidosDao dao) {
		super();
		this.template = template;
		this.dao = dao;
	}

	@Override
	public boolean altaPedido(Pedido pedido) {
		System.out.println("Estoy en el service " + pedido.getCodigoProducto() + " " + pedido.getUnidades());
		
		ResponseEntity<String> response = template.exchange(urlBase + "ActualizarProducto/{codigoProducto}/{unidadesCompradas}", 
				HttpMethod.PUT,
				null,
				String.class,
				pedido.getCodigoProducto(),
				pedido.getUnidades());
		
		String cuerpo = response.getBody();
		
		if(cuerpo.equals("true")) {
			pedido.setFechaPedido(new Date());
			pedido.setTotal(pedido.getUnidades()* obtenerPrecio(pedido.getCodigoProducto()));
			dao.save(pedido);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Pedido> pedidos() {
		return dao.findAll();
	}
	
	private double obtenerPrecio(int codigoProducto) {
		return Double.parseDouble(template.getForObject(urlBase + "Precio/{codigoProducto}", String.class, codigoProducto));
	}
}
