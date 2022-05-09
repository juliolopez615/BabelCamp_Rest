package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;
@Service
public class PaisesServiceImpl implements PaisesService {
	
	RestTemplate template;
	
	
	public PaisesServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	String url="https://restcountries.com/v2/all";
	Pais[] paises;
	@PostConstruct
	public void init(){
	
		paises= template.getForObject(url, Pais[].class);
				
	}
	@Override
	public List<String> continentes() {
		return Arrays.stream(paises)
		.map(p->p.getContinente())
		.distinct()
		.collect(Collectors.toList());
	}

	@Override
	public List<Pais> paisesContinente(String continente) {
		return Arrays.stream(paises)
				.filter(p->p.getContinente().equals(continente))
				.collect(Collectors.toList());
	}
	@Override
	public long poblacionContinente(String continente) {
		return Arrays.stream(paises)
				.filter(p->p.getContinente().equals(continente))
				//.collect(Collectors.summingLong(p->p.getHabitantes()));
				.mapToLong(p->p.getHabitantes())
				.sum();
				
				
	}

	

}
