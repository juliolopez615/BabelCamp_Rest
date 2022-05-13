package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {
	void reservar(Reserva reserva, int personas);
	List<Reserva> listaReservas();
}
