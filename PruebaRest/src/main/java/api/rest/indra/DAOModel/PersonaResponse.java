package api.rest.indra.DAOModel;

import java.util.List;

import api.rest.indra.model.Persona;

public class PersonaResponse{
	private int codeStatus;
	private String msg;
	private List<Persona> personas;
	public int getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(int codeStatus) {
		this.codeStatus = codeStatus;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	
	
}
