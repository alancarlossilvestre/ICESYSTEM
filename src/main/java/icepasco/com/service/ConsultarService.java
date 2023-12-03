package icepasco.com.service;

import java.util.List;

import org.springframework.stereotype.Service;


import icepasco.com.repository.ConsultarRepository;
import icewe.com.entity.ResultadoConsulta;


@Service
public class ConsultarService {
	private final ConsultarRepository consultarRepository;
	
	 public ConsultarService(ConsultarRepository consultaRepository) {
	        this.consultarRepository = consultaRepository;
	    }

	    public List<ResultadoConsulta> obtenerResultadosConsulta() {
	        return consultarRepository.realizarConsulta();
	    }
	    public List<ResultadoConsulta> obtenerResultadosConsultaV() {
	        return consultarRepository.realizarConsultaV();
	    }
	    
}
