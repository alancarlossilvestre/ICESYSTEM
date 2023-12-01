package icepasco.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import icewe.com.entity.IPersona;


@Controller
public class EdicionController {
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EdicionController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para mostrar el formulario de edición
    @GetMapping("/editar/{dni}")
    public String mostrarFormularioEdicion(@PathVariable int dni, Model model) {
        // Lógica para obtener los datos de la persona con el DNI especificado
        // y pasarlos al modelo
        String sql = "SELECT * FROM persona WHERE dni = ?";
        IPersona persona = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(IPersona.class), dni);
        model.addAttribute("persona", persona);
        return "formulario_edicion"; // Nombre del archivo HTML sin la extensión
    }

    // Método para manejar la actualización de una persona
    @PostMapping("/editar")
    public String editarPersona(@ModelAttribute IPersona persona) {
        try {
            // Actualizar en la tabla persona
            String sqlPersona = "UPDATE persona SET dni=?, nombres=?, apellidos=? WHERE dni=?";
            jdbcTemplate.update(sqlPersona, persona.getDni(), persona.getNombres(), persona.getApellidos(), persona.getDni());

            // Actualizar en la tabla detalle_persona
            String sqlDetallePersona = "UPDATE detalle_persona SET edad=?, sexo=?, correo=?, direccion=?, grado_instruccion=? WHERE dni=?";
            jdbcTemplate.update(sqlDetallePersona, persona.getEdad(), persona.getSexo(), persona.getCorreo(), persona.getDireccion(), persona.getGrado_instruccion(), persona.getDni());
            
            // Actualizar en la tabla informacion_ecclesiastica
            String sqlLugarCongregacion = "UPDATE informacion_ecclesiastica SET lugarCongregacion=? WHERE persona_dni=?";
            jdbcTemplate.update(sqlLugarCongregacion, persona.getLugarCongregacion(), persona.getDni());

            // Después de la actualización, redirige a la URL /resultado para mostrar los resultados actualizados
            return "redirect:/resultado";
        } catch (Exception e) {
            // En caso de error, realiza un rollback de la transacción
            throw new RuntimeException("Error al editar", e);
        }
    }
}
