package service;

import java.util.List;

import model.Hotel;

public interface HotelesService{
	Hotel findByNombre(String nombre);
	List<Hotel> findByDisponibilidad();
}
