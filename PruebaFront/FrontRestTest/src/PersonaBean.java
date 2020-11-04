import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import util.PersonaCrud;

@Named
@RequestScoped
public class PersonaBean {
	
	private Long id;
	private String nombres;
	private String apellidos;
	private String cedula;
	private String genero;
	private int edad;
	private PersonaCrud srvPersona;
	
	public PersonaBean() {
		srvPersona = new PersonaCrud();
	}
	
	public void acciones() {
		setNombres(srvPersona.crear());
	}
	
	public PersonaCrud getSrvPersona() {
		return srvPersona;
	}
	public void setSrvPersona(PersonaCrud srvPersona) {
		this.srvPersona = srvPersona;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
