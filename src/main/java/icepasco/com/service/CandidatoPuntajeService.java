package icepasco.com.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CandidatoPuntajeService {
	 private final JdbcTemplate jdbcTemplate;
	 public CandidatoPuntajeService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public void guardarPuntaje(String dni, int totalVotos) {
	        // Verificar si ya existe una entrada para el candidato en la tabla
	        String sqlSelect = "SELECT COUNT(*) FROM candidatos_puntaje WHERE dni = ?";
	        int count = jdbcTemplate.queryForObject(sqlSelect, Integer.class, dni);

	        if (count > 0) {
	            // Si existe, actualizar el puntaje
	            String sqlUpdate = "UPDATE candidatos_puntaje SET total_votos = ? WHERE dni = ?";
	            jdbcTemplate.update(sqlUpdate, totalVotos, dni);
	        } else {
	            // Si no existe, insertar una nueva entrada
	            String sqlInsert = "INSERT INTO candidatos_puntaje (dni, total_votos) VALUES (?, ?)";
	            jdbcTemplate.update(sqlInsert, dni, totalVotos);
	        }
	    }
}
