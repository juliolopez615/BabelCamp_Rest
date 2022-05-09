package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	List<String> continentes();
	List<Pais> paisesContinente(String continente);
	long poblacionContinente(String continente);
}
