package api.rest.indra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name="nombres")
	private String nombres;
	
	@Column (name="apellidos")
	private String apellidos;
	
	@Column (name="cedula")
	private String cedula;
	
	@Column (name="genero")
	private String genero;
	
	@Column (name="Edad")
	private String Edad;
	
	
	
//	public Persona(String nombres, String apellidos, String cedula, String genero, String edad) {
//		super();
//		this.nombres = nombres;
//		this.apellidos = apellidos;
//		this.cedula = cedula;
//		this.genero = genero;
//		Edad = edad;
//	}
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
	public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad = edad;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + "]";
	}

}
