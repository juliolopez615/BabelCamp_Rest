package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {
	VuelosDao dao;
	
	
	public VuelosServiceImpl(@Autowired VuelosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Vuelo> disponibles(int plazas) {
		List<Vuelo> vuelos = dao.findAll()
				.stream()
				.filter(v->v.getPlazas() - plazas >= 0)
				.collect(Collectors.toList());
		
		return vuelos.size() > 0 ? vuelos:null;
	}

	@Override
	public boolean actuaizarVuelo(int idVuelo, int plazas) {
		Vuelo v = dao.findById(idVuelo).orElse(null);
		
		if(v != null) {
			if(v.getPlazas() - plazas >= 0) {
				v.setPlazas(v.getPlazas() - plazas);
				dao.save(v);
				return true;
			}
		}
		
		return false;
	}

}
