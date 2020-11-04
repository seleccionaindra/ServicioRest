package api.rest.indra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.rest.indra.DAOModel.PersonaRepo;
import api.rest.indra.DAOModel.PersonaResponse;
import api.rest.indra.model.Persona;

@Service
@Transactional
public class PersonaServImpl implements IPersonaServ{
	
	@Autowired
	private PersonaRepo repo;


	@Override
	public PersonaResponse consultarPersonas() {
		PersonaResponse resp = new PersonaResponse();
		List<Persona> personas;
		try{
			personas = this.repo.findAll();
			resp.setCodeStatus(0);
			resp.setMsg("Consulta exitosa");
			resp.setPersonas(personas);
		} catch (Exception ex) {
			resp.setCodeStatus(1);
			resp.setMsg("Error: "+ex.getMessage());
		}
		return resp;
	}
	
	@Override
	public PersonaResponse crearPersona(Persona persona) {
		PersonaResponse resp = new PersonaResponse();
		List<Persona> personas = new ArrayList<Persona>();
		Persona personaResp = new Persona();
		try{
			personaResp = this.repo.save(persona);
			personas.add(personaResp);
			resp.setCodeStatus(0);
			resp.setMsg("Creación exitosa");
			resp.setPersonas(personas);
		} catch (Exception ex) {
			resp.setCodeStatus(1);
			resp.setMsg("Error: "+ex.getMessage());
		}
		return resp;
	}

	@Override
	public PersonaResponse modificarPersona(Persona persona) {
		Optional<Persona> personaDB;
		PersonaResponse resp = new PersonaResponse();
		List<Persona> personas = new ArrayList<Persona>();
		try{
			personaDB = this.repo.findById(persona.getId());
			if (personaDB.isPresent()) {
				Persona personaActualiza = personaDB.get();
				
				personaActualiza.setNombres(persona.getNombres());
				personaActualiza.setApellidos(persona.getApellidos());
				personaActualiza.setGenero(persona.getGenero());
				personaActualiza.setEdad(persona.getEdad());
				
				this.repo.save(personaActualiza);
				personas.add(personaActualiza);
				resp.setCodeStatus(0);
				resp.setMsg("Actualización exitosa");
				resp.setPersonas(personas);
				
			} else {
				resp.setCodeStatus(1);
				resp.setMsg("Error: No se encontró la persona con ID = {"+persona.getId()+"}");
			}
		} catch (Exception ex) {
			resp.setCodeStatus(1);
			resp.setMsg("Error: "+ex.getMessage());
		}
		return resp;
	}

	@Override
	public PersonaResponse consultarPersona(Long id) {
		Optional<Persona> personaDB;
		PersonaResponse resp = new PersonaResponse();
		List<Persona> personas = new ArrayList<Persona>();
		try{
			personaDB = this.repo.findById(id);
			if (personaDB.isPresent()) {
				Persona personaBusqueda = personaDB.get();
				
				personas.add(personaBusqueda);
				resp.setCodeStatus(0);
				resp.setMsg("Consulta exitosa");
				resp.setPersonas(personas);
				
			} else {
				resp.setCodeStatus(1);
				resp.setMsg("Error: No se encontró la persona con ID = {"+id+"}");
			}
		} catch (Exception ex) {
			resp.setCodeStatus(1);
			resp.setMsg("Error: "+ex.getMessage());
		}
		return resp;
	}

	@Override
	public PersonaResponse borrarPersona(Long id) {
		Optional<Persona> personaDB;
		PersonaResponse resp = new PersonaResponse();
		List<Persona> personas = new ArrayList<Persona>();
		try{
			personaDB = this.repo.findById(id);
			if (personaDB.isPresent()) {
				Persona personaBorra = personaDB.get();
				
				this.repo.delete(personaBorra);
				personas.add(personaBorra);
				resp.setCodeStatus(0);
				resp.setMsg("Eliminación exitosa");
				resp.setPersonas(personas);
				
			} else {
				resp.setCodeStatus(1);
				resp.setMsg("Error: No se encontró la persona con ID = {"+id+"}");
			}
		} catch (Exception ex) {
			resp.setCodeStatus(1);
			resp.setMsg("Error: "+ex.getMessage());
		}
		return resp;
	}

}
