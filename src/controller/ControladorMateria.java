package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Materia;
import model.Nivel;

public class ControladorMateria {
	
	
	
	/*
	 * 
	 */
	public static List<Materia> findAll () {
		
		List<Materia> lista = new ArrayList<Materia>();
		
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from materia");
		   
			
			while (rs.next()) {
				Materia m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getInt("idNivel"), rs.getString("codigo")
						, rs.getString("urlClassroom"), rs.getBoolean("urlClassroom"), rs.getDate("urlClassroom"));
				lista.add(m);
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
	/**
	 * 
	 */
	public static List<Materia> findByIdNivel (int idNivel) {
		
		List<Materia> lista = new ArrayList<Materia>();
		
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from materia where idNivel = " + idNivel);
		   
			
			while (rs.next()) {
				Materia m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getInt("idNivel"), rs.getString("codigo")
						, rs.getString("urlClassroom"), rs.getBoolean("urlClassroom"), rs.getDate("urlClassroom"));
				lista.add(m);
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

	/**
	 * 
	 * @param nombreTabla
	 * @return
	 */
	protected static int siguienteIdEnTabla() {
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select max(id) from materia");
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 		
	}

	
	
	
	/**
	 * 
	 */
	public static int modificar (Materia m) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update estudiante set nombre = ?, idNivel = ?, codigo = ?, urlClassroom = ?, admiteMatricula = ?, fechaInicio = ? where id = ?");
		
			
			ps.setString(1, m.getNombre());
			ps.setInt(2, m.getIdNivel());
			ps.setString(3, m.getCodigo());
			ps.setString(4, m.getUrlClassroom());
			ps.setString(5, m.getCodigo());
			ps.setString(6, m.getUrlClassroom());
			ps.setInt(7, m.getId());
			
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
		
	}
}
