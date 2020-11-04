package api.rest.indra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.model.Persona;
import api.rest.indra.service.IPersonaServ;

@RestController
@RequestMapping("svc/v1/personas")
public class PersonaRest {
	
	@Autowired
	private IPersonaServ serv;
	
	@PostMapping("/crear")
	public Object crearPersona (@RequestBody Persona persona) {
		return serv.crearPersona(persona);
	}

	@PutMapping("/actualizar/{id}")
	public Object actualizarPersona (@PathVariable Long id,@RequestBody Persona persona) {
		persona.setId(id);
		return serv.modificarPersona(persona);
	}

	@GetMapping("/listar")
	public Object listarPersonas () {
		return serv.consultarPersonas();
	}
	
	@GetMapping("/consultar/{id}")
	public Object consultarPersona (@PathVariable Long id) {
		return serv.consultarPersona(id);
	}
	
	@DeleteMapping("/borrar/{id}")
	public Object borrarPersona (@PathVariable Long id) {
		return serv.borrarPersona(id);
	}

}
