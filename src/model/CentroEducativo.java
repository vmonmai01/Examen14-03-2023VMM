package model;

public class CentroEducativo {

	private int id;
	private String descripcion;
	
	/*
	 * 
	 */
	public CentroEducativo() {
		super();
		
	}

	/*
	 * 
	 */
	public CentroEducativo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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

	
	/*
	 * 	ToString
	 */
	public String toString() {
		return  descripcion ;
	}
	
	
	
}
