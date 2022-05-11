package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {
	List<Vuelo> disponibles(int plazas);
	boolean actuaizarVuelo(int idVuelo, int plazas);
}
