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
        String sql = "SELECT\r\n"
        		+ "    `persona`.`foto`,\r\n"
        		+ "    `persona`.`apellidos`,\r\n"
        		+ "    `persona`.`nombres`,\r\n"
        		+ "    `detalle_persona`.`edad`,\r\n"
        		+ "    `detalle_persona`.`sexo`,\r\n"
        		+ "    `detalle_persona`.`correo`,\r\n"
        		+ "    `detalle_persona`.`direccion`,\r\n"
        		+ "    `detalle_persona`.`grado_instruccion`,\r\n"
        		+ "    `informacion_ecclesiastica`.`grado_instruccion` AS `grado_instruccion_ecclesiastica`,\r\n"
        		+ "    `areas_iglesia`.`nombre_area` AS `area_de_trabajo`,\r\n"
        		+ "    `anexo`.`nombre_anexo` AS `nombre_lugar_congregacion`\r\n"
        		+ "FROM\r\n"
        		+ "    `persona`\r\n"
        		+ "LEFT JOIN\r\n"
        		+ "    `detalle_persona` ON `detalle_persona`.`DNI` = `persona`.`dni`\r\n"
        		+ "LEFT JOIN\r\n"
        		+ "    `informacion_ecclesiastica` ON `informacion_ecclesiastica`.`persona_dni` = `persona`.`dni`\r\n"
        		+ "LEFT JOIN\r\n"
        		+ "    `areas_iglesia` ON `informacion_ecclesiastica`.`area_iglesia_id` = `areas_iglesia`.`id`\r\n"
        		+ "LEFT JOIN\r\n"
        		+ "    `anexo` ON `informacion_ecclesiastica`.`lugarCongregacion` = `anexo`.`id`;\r\n";
        

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResultadoConsulta.class));
    }
}
