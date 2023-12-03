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
        String sql2 = "SELECT p.foto, p.dni, p.nombres, p.apellidos, dp.sexo, cp.numero_votos\r\n"
        		+ "FROM persona p\r\n"
        		+ "JOIN detalle_persona dp ON p.dni = dp.dni\r\n"
        		+ "JOIN candidatos_puntaje cp ON p.dni = cp.persona_dni\r\n"
        		+ "ORDER BY dp.sexo DESC, cp.numero_votos DESC;\r\n";
    
        return jdbcTemplate.query(sql2,  new BeanPropertyRowMapper<>(ResultadoConsulta.class));
    } 
    
}
