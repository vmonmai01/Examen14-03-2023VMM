package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.ControladorCentroEducativo;
import controller.ControladorMateria;
import controller.ControladorNivel;
import model.CentroEducativo;
import model.Materia;
import model.Nivel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionMaterias extends JPanel {

	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFecha;
	private JComboBox<CentroEducativo> jcbCentro;
	private JComboBox<Nivel> jcbNivel;
	private JComboBox<Materia> jcbMateria;
	private JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public PanelGestionMaterias() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel Titulo = new JLabel("Gestión de Materias");
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_Titulo = new GridBagConstraints();
		gbc_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_Titulo.gridwidth = 0;
		gbc_Titulo.gridx = 1;
		gbc_Titulo.gridy = 0;
		add(Titulo, gbc_Titulo);

		JLabel lblNewLabel = new JLabel("Centro :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbCentro = new JComboBox();
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		add(jcbCentro, gbc_jcbCentro);

		JButton btnCNiveles = new JButton("Cargar niveles");
		btnCNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filtrarNivelesPorCentroSeleccionado();
			}
		});
		GridBagConstraints gbc_btnCNiveles = new GridBagConstraints();
		gbc_btnCNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_btnCNiveles.gridx = 3;
		gbc_btnCNiveles.gridy = 1;
		add(btnCNiveles, gbc_btnCNiveles);

		JLabel lblNewLabel_1 = new JLabel("Nivel :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbNivel = new JComboBox();
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		add(jcbNivel, gbc_jcbNivel);

		JButton btnCMaterias = new JButton("Cargar Materias");
		btnCMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filtrarMateriaPorNivelSeleccionado();
			}
		});
		GridBagConstraints gbc_btnCMaterias = new GridBagConstraints();
		gbc_btnCMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnCMaterias.gridx = 3;
		gbc_btnCMaterias.gridy = 2;
		add(btnCMaterias, gbc_btnCMaterias);

		JLabel lblNewLabel_2 = new JLabel("Materia :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		add(jcbMateria, gbc_jcbMateria);

		JButton btnVMateria = new JButton("Ver Materia");
		btnVMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrarMaterias();
			}
		});
		GridBagConstraints gbc_btnVMateria = new GridBagConstraints();
		gbc_btnVMateria.insets = new Insets(0, 0, 5, 0);
		gbc_btnVMateria.gridx = 3;
		gbc_btnVMateria.gridy = 3;
		add(btnVMateria, gbc_btnVMateria);

		JLabel titulo2 = new JLabel("Datos Materia");
		titulo2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_titulo2 = new GridBagConstraints();
		gbc_titulo2.insets = new Insets(0, 0, 5, 5);
		gbc_titulo2.gridx = 1;
		gbc_titulo2.gridy = 4;
		add(titulo2, gbc_titulo2);

		JLabel lblNewLabel_3 = new JLabel("Id :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 0;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Código :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.gridwidth = 0;
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("URL Classroom :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.gridwidth = 0;
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fecha inicio :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 0;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		JCheckBox chbxAdmite = new JCheckBox(" Admite matrícula");
		GridBagConstraints gbc_chbxAdmite = new GridBagConstraints();
		gbc_chbxAdmite.insets = new Insets(0, 0, 5, 5);
		gbc_chbxAdmite.gridx = 1;
		gbc_chbxAdmite.gridy = 10;
		add(chbxAdmite, gbc_chbxAdmite);

		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 11;
		add(btnGuardar, gbc_btnGuardar);

		cargarCentrosEnComboBox();
		cargarNivelesEnComboBox();

	}

	/*
	 * Métodos para acciones
	 */

	/**
	 * 
	 */
	private void cargarCentrosEnComboBox() {
		List<CentroEducativo> centros = ControladorCentroEducativo.findAll();
		for (CentroEducativo c : centros) {
			this.jcbCentro.addItem(c);
		}
	}

	/*
	 * 
	 */
	private void cargarNivelesEnComboBox() {
		List<Nivel> niveles = ControladorNivel.findAll();
		for (Nivel n : niveles) {
			this.jcbNivel.addItem(n);
		}
	}

	/*
	 * 
	 */
	private void cargarMateriaEnComboBox() {

		int idNivelSeleccionado = ((Nivel) this.jcbNivel.getSelectedItem()).getId();

		this.jcbMateria.removeAllItems();

		List<Materia> materias = ControladorMateria.findByIdNivel(idNivelSeleccionado);

		for (Materia m : materias) {

			this.jcbMateria.addItem(m);
		}
	}

	/**
	 * 
	 */
	private void filtrarNivelesPorCentroSeleccionado() {
		int idCentroSeleccionado = ((CentroEducativo) this.jcbCentro.getSelectedItem()).getId();

		this.jcbNivel.removeAllItems();

		List<Nivel> niveles = ControladorNivel.findByIdCentro(idCentroSeleccionado);
		for (Nivel n : niveles) {
			this.jcbNivel.addItem(n);
		}
	}

	/**
	 * 
	 */
	private void filtrarMateriaPorNivelSeleccionado() {

		int idNivelSeleccionado = ((Nivel) this.jcbNivel.getSelectedItem()).getId();

		this.jcbMateria.removeAllItems();

		List<Materia> materias = ControladorMateria.findByIdNivel(idNivelSeleccionado);

		for (Materia m : materias) {

			this.jcbMateria.addItem(m);

			if (m != null) {
				this.jtfId.setText("" + m.getId());
				this.jtfNombre.setText(m.getNombre());
				this.jtfCodigo.setText(m.getCodigo());
				this.jtfUrl.setText(m.getUrlClassroom());
			}
		}

	}

	private void mostrarMaterias() {

		List<Materia> materias = ControladorMateria.findAll();

		for (Materia m : materias) {

			this.jcbMateria.addItem(m);

			if (m != null) {
				this.jtfId.setText("" + m.getId());
				this.jtfNombre.setText(m.getNombre());
				this.jtfCodigo.setText(m.getCodigo());
				this.jtfUrl.setText(m.getUrlClassroom());
			}
		}

	}

	private void guardarDatosFormulario() {

		
		// Compruebo que exista al menos 3 minúscula, 3 mayúscula  (no se como hacer para que sean 3 )
				boolean mayuscula = false, minuscula = false;
				
				String url = this.jtfUrl.getText();
				for (int i = 0; i < url.length(); i++) {
					if (Character.isLowerCase(url.charAt(i))) minuscula = true;
					else if (Character.isUpperCase(url.charAt(i))) mayuscula = true;
					
				}
				
				if (!mayuscula || !minuscula ) {
					JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos una mayúscula, una minúscula ");
					return;
				}

				// Finalmente guardo la materia
				Materia m = new Materia();
				
				m.setId(this.jtfId.getText());
				m.setNombre(this.jtfNombre.getText());
				m.setIdNivel(this.jtfIdNivel.getText());
				m.setCodigo(((Nivel) this.jcbNivel.getSelectedItem()).getId());
				m.setUrlClassroom(this.jtfUrl.getText());
				
				
				if (ControladorMateria.findAll() > 0) {
					
					JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente");
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario no puede guardarse");
				}
				
	}
}
