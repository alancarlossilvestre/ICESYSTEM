package icepasco.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EliminarService {
	private final JdbcTemplate jdbcTemplate; // Asegúrate de tener un bean de JdbcTemplate configurado

	@Autowired
	public EliminarService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
    public void eliminarPersonaConRelaciones(String dni) {
		 // Elimina de detalle_persona
        jdbcTemplate.update("DELETE FROM detalle_persona WHERE dni = ?", dni);

        // Elimina de diezmo
        jdbcTemplate.update("DELETE FROM diezmo WHERE persona_dni = ?", dni);

        // Elimina de candidatos_puntaje
        jdbcTemplate.update("DELETE FROM candidatos_puntaje WHERE persona_dni = ?", dni);

        // Elimina de informacion_eclesiastica
        jdbcTemplate.update("DELETE FROM informacion_ecclesiastica WHERE persona_dni = ?", dni);

        // Elimina de familia
        jdbcTemplate.update("DELETE FROM familia WHERE persona_dni = ? OR papa_dni = ? OR mama_dni = ? OR hermano_dni = ? OR hermana_dni = ?",
                            dni, dni, dni, dni, dni);

        // Finalmente, elimina de persona
        jdbcTemplate.update("DELETE FROM persona WHERE dni = ?", dni);
    
	}
	

	
}
