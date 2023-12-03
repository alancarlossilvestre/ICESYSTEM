package icepasco.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	@GetMapping({"/inicio", "/", "home"})	
	public String inicio(ModelMap model) {
		model.addAttribute("tituloCabecera", "Eleccionces ICE");
		model.addAttribute("tituloGeneral","Hola jp");
		return "inicioView";
		}
	@GetMapping("/pruebas")
	public String mostrarPruebas() {	     
	        return "pruebas";
	    }

	 @GetMapping("/2")
	    public String mostrarElecciones() {
	      
	        return "candidatosView";
	    }
}
