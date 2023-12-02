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
        String sql = "SELECT * FROM persona;";
        

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResultadoConsulta.class));
    }
}
