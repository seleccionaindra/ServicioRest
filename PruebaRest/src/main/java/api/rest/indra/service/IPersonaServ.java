package api.rest.indra.service;

import java.util.List;

import api.rest.indra.DAOModel.PersonaResponse;
import api.rest.indra.model.Persona;

public interface IPersonaServ {
	
	PersonaResponse crearPersona(Persona persona);
	PersonaResponse modificarPersona(Persona persona);
	PersonaResponse consultarPersona(Long id);
	PersonaResponse consultarPersonas();
	PersonaResponse borrarPersona(Long id);

}
