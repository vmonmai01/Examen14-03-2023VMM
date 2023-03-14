package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800, 800));
		JTabbedPane tabedPane = new JTabbedPane();

//		Adicion de Paneles
		tabedPane.add("Gestión de Materias", new PanelGestionMaterias());
	
		
		this.setMinimumSize(new Dimension(600, 400));

		this.setContentPane(tabedPane);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
