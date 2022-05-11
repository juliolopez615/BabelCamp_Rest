package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	RestTemplate template;
	ReservasDao dao;
	String urlBase="http://servicio-vuelos/vuelo/";
	
	public ReservasServiceImpl(@Autowired ReservasDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}
	
	//ActualizarVuelo/3/1
	@Override
	public void reservar(Reserva reserva, int personas) {
		//template.put(urlBase + "ActualizarVuelo/{id}/{plazas}" + reserva.getVuelo()
		//+"/" + personas, null);
		ResponseEntity<String> response = template.exchange(urlBase + "ActualizarVuelo/{id}/{plazas}", 
				HttpMethod.PUT,
				null,
				String.class,
				reserva.getVuelo(),
				personas);
		
		String cuerpo = response.getBody();
		
		if(cuerpo.equals("true")) {
			dao.save(reserva);
		}
				
	}

	@Override
	public List<Reserva> listaReservas() {
		return dao.findAll();
	}

}
