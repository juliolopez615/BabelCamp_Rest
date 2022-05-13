package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	HotelesDao dao;
	
	
	
	public HotelesServiceImpl(@Autowired HotelesDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Hotel findByNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	@Override
	public List<Hotel> findByDisponibilidad() {
		List <Hotel> hoteles = dao.findAll()
				.stream()
				.filter(h->h.getDisponible() == 1)
				.collect(Collectors.toList());
		return hoteles.size() > 0 ? hoteles:null;
	}

}
