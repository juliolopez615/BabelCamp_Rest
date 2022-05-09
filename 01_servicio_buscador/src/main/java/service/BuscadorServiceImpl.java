package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

@Service
public class BuscadorServiceImpl implements BuscadorService {
	static ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorServiceImpl() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y más cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","Música de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","Música de actualidad"));
	}
	//bucamos las páginas cuya temática coincida con la recibida
	//como parámetro
	public List<Pagina> buscar(String tematica){
		return paginas
				.stream()
				.filter(p->p.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}
	
	public void aniadir(Pagina pagina) {
		paginas.add(new Pagina(pagina.getDireccion(), pagina.getTematica(), pagina.getDescripcion()));
	}
	@Override
	public List<Pagina> paginas() {
		return paginas;
	}
	@Override
	public void eliminar(String tematica) {
		paginas.removeIf(p->p.getTematica().equals(tematica));
		
	}
	@Override
	public Pagina actualizar(Pagina pagina) {
		for(int i=0; i< paginas.size(); i++) {
			if(paginas.get(i).getDireccion().equals(pagina.getDireccion())) {
				paginas.set(i, pagina);
				return pagina;
			}
		}
		return null; // devuelve null si la página no existe
	}
	@Override
	public void actualizarTematica(String direccion, String nuevaTematica) {
		paginas.forEach(p->{
			if(p.getDireccion().equals(direccion)) {
				p.setTematica(nuevaTematica);
			}
		});
		
	}
	

}
