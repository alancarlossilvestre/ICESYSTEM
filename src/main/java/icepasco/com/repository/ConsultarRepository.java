package icepasco.com.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import icewe.com.entity.ResultadoConsulta;


@Repository
public class ConsultarRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public ConsultarRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

    public List<ResultadoConsulta> realizarConsulta() {
        String sql = "SELECT * FROM persona";
    
        return jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(ResultadoConsulta.class));
    } 
    
    public List<ResultadoConsulta> realizarConsultaV() {
        String sql2 = "SELECT \r\n"
        		+ "    p.dni,\r\n"
        		+ "    p.foto,\r\n"
        		+ "    p.nombres,\r\n"
        		+ "    p.apellidos,\r\n"
        		+ "    cp.numero_votos\r\n"
        		+ "FROM \r\n"
        		+ "    persona p\r\n"
        		+ "JOIN \r\n"
        		+ "    candidatos_puntaje cp ON p.dni = cp.persona_dni\r\n"
        		+ "ORDER BY \r\n"
        		+ "    cp.numero_votos DESC;";
    
        return jdbcTemplate.query(sql2,  new BeanPropertyRowMapper<>(ResultadoConsulta.class));
    } 
    
}
