package model;

import java.sql.Date;

public class Materia {

	private int id;
	private String nombre;
	private int idNivel;
	private String codigo;
	private String urlClassroom;
	private boolean adminteMatricula;
	private Date fechaInicio;
	
	/* 
	 * Contructor
	 */
	public Materia() {
		super();
		
	}

	/* 
	 * Contructor using Field
	 */
	public Materia(int id, String nombre, int idNivel, String codigo, String urlClassroom, boolean adminteMatricula,
			Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idNivel = idNivel;
		this.codigo = codigo;
		this.urlClassroom = urlClassroom;
		this.adminteMatricula = adminteMatricula;
		this.fechaInicio = fechaInicio;
	}

	
/*
 * 		Getter & Setter
 */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getIdNivel() {
		return idNivel;
	}


	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getUrlClassroom() {
		return urlClassroom;
	}


	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}


	public boolean isAdminteMatricula() {
		return adminteMatricula;
	}


	public void setAdminteMatricula(boolean adminteMatricula) {
		this.adminteMatricula = adminteMatricula;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	/*
	 *  To String
	 */
	public String toString() {
		return nombre +  idNivel ;
	}
	
	
	
	
}
