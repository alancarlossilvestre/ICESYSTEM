package icepasco.com.controllers;

import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import icepasco.com.service.ConsultarService;
import icewe.com.entity.IPersona;
import icewe.com.entity.ResultadoConsulta;
import jakarta.transaction.Transactional;




@Controller
public class ConsultaController {
	
	private final JdbcTemplate jdbcTemplate;
	private final ConsultarService consultaService;
		
    @Autowired
    public ConsultaController(@Qualifier("dataSource")DataSource dataSource, ConsultarService consultaService) {
    	this.jdbcTemplate = new JdbcTemplate (dataSource);
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<ResultadoConsulta> obtenerResultadosConsulta() {
        return consultaService.obtenerResultadosConsulta();
    }
    @GetMapping("/resultado")
    public String mostrarResultados(Model  model) {
        List<ResultadoConsulta> resultados = consultaService.obtenerResultadosConsulta();
        // Convertir bytes a base64 para la propiedad 'foto'
        resultados.forEach(resultado -> {
            if (resultado.getFoto() != null) {
                String base64Foto = Base64.getEncoder().encodeToString(resultado.getFoto());
                resultado.setBase64Foto(base64Foto);
            }
        });
        model.addAttribute("resultados", resultados);
        return "mostrarConsulta"; // El nombre del archivo HTML sin la extensión
    }
    
    // Método para mostrar el formulario de inserción
    @GetMapping("/insertarForm")
    public String mostrarFormularioInsercion() {
        return "formulario_insertar"; // Nombre del archivo HTML sin la extensión
    }

    // Método para manejar la inserción de una persona
    @Transactional
    @PostMapping("/insertarPersona")
    public String insertarPersona(@ModelAttribute("ipersona") IPersona persona) {
    	System.out.println("Recibiendo solicitud POST en /insertarPersona");
    	System.out.println("DNI recibido: " + persona.getDni());
    	
    	try {
            // Insertar en la tabla persona
            String sqlPersona = "INSERT INTO persona (dni, nombres, apellidos, foto) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sqlPersona, persona.getDni(), persona.getNombres(), persona.getApellidos(), persona.getFoto());

            // Insertar en la tabla detalle_persona
            String sqlDetallePersona = "INSERT INTO detalle_persona (dni, edad, sexo, correo, direccion, grado_instruccion) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sqlDetallePersona, persona.getDni(), persona.getEdad(), persona.getSexo(), persona.getCorreo(), persona.getDireccion(), persona.getGrado_instruccion());
            
            // Insertar iformacion Eclesiastica
            String sqlLugarCongregacion = "INSERT INTO informacion_ecclesiastica (persona_dni, lugarCongregacion, area_iglesia_id) VALUES (?,?,?)";
            jdbcTemplate.update(sqlLugarCongregacion, persona.getDni(), persona.getLugarCongregacion(), persona.getAreaTrabajo());
            
            // Después de la inserción, redirige a la URL /resultado para mostrar los resultados actualizados
            return "redirect:/resultado";
        } catch (Exception e) {
            // En caso de error, realiza un rollback de la transacción
            throw new RuntimeException("Error al insertar", e);
        }
         
    }

}
