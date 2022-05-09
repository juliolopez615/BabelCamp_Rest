package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	RestTemplate template;
	ReservasDao dao;
	String urlBase="http://localhost:8001/vuelo/";
	
	public ReservasServiceImpl(@Autowired ReservasDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}
	
	//ActualizarVuelo/3/1
	@Override
	public void reservar(Reserva reserva, int personas) {
		template.put(urlBase + "ActualizarVuelo/" + reserva.getVuelo()
		+"/" + personas, Vuelo.class);
		dao.save(reserva);		
	}

	@Override
	public List<Reserva> listaReservas() {
		return dao.findAll();
	}

}
