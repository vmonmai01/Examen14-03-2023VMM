package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CentroEducativo;

public class ControladorCentroEducativo {

	/**
	 * 
	 */
	public static List<CentroEducativo> findAll () {
		List<CentroEducativo> lista = new ArrayList<CentroEducativo>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from centroeducativo");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				CentroEducativo c = new CentroEducativo(rs.getInt("id"), rs.getString("descripcion"));
				lista.add(c);
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return lista;
	}
}
