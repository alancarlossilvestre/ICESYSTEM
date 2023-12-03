package icepasco.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votos")
public class VotosController {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@PostMapping("/insertarv")
    public void insertarVoto(@RequestParam int dni, @RequestParam int cantidadVotos) {
        String sql = "INSERT INTO candidatos_puntaje (id, numero_votos, persona_dni) VALUES (null, ?, ?)";
        jdbcTemplate.update(sql, cantidadVotos, dni);
    }

}
