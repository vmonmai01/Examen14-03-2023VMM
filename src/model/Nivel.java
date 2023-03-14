package model;

public class Nivel {

	private int id;
	private String descripcion;
	private int idCentro;
	
	/*
	 *	Constructor 	
	 */
	public Nivel() {
		super();
		
	}
	/*
	 *	Constructor using Fields	
	 */
	public Nivel(int id, String descripcion, int idCentro) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idCentro = idCentro;
	}
	
	
	/*
	 * 	Getter & Setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	
	
	
	/*
	 *  To String
	 */
	public String toString() {
		return  descripcion ;
	}
	
	
	
}
