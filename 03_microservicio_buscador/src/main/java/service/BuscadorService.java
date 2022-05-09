package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List<Pagina> buscar(String tematica);
	public void aniadir(Pagina pagina);
	List<Pagina> paginas();
	public void eliminar(String tematica);
	public Pagina actualizar(Pagina pagina);
	public void actualizarTematica(String direccion, String nuevaTematica);
}
