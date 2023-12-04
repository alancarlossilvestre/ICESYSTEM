package icepasco.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import icepasco.com.service.EliminarService;

@Controller
@RequestMapping("/eliminar")
public class EliminarController {
    @Autowired
    private EliminarService personaService; // Asegúrate de tener un servicio adecuado

    @GetMapping("/{dni}")
    public String eliminarPersona(@PathVariable String dni) {
        personaService.eliminarPersonaConRelaciones(dni);
        return "redirect:/candidatos"; // Redirige a la página de resultados después de eliminar
    }


}
