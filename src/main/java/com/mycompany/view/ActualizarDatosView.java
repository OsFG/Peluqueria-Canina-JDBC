package com.mycompany.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mycompany.controller.DuenioController;
import com.mycompany.controller.MascotaController;
import com.mycompany.modelo.mascota.Raza;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class ActualizarDatosView extends JFrame {

	private JPanel panelActualizarDatos, panel, panelDuenios, panelBotonesDuenio, panelBotonesMascota;
	private JLabel lblTituloPrincipal, lblNombreDuenio, lblTelefono, lblDireccion, lblIdDuenio, lblAtencionEsp, lblAlergico, lblObservaciones, lblNombreMascota, lblIdMascota; 
	private JTextArea txtNombreDuenio, txtTelefono, txtDireccion, txtIdDuenio, txtAtencionEsp, txtAlergico, txtObservaciones, txtIdMascota, txtNombreM;
	private JButton btnGuardar, btnEliminar, btnBuscar, btnGuardarM, btnEliminarM;
	private JComboBox<Raza> cbxRaza;
	private JLabel lblRaza;
	
	private RegistrarDatosView ventanaRegistrarDatos;
	private Integer idDuenio;
	private String nombreDuenio;
	private String telefono;
	
	private DuenioController duenioController;
	private MascotaController mascotaController;
	private JButton btnLimpiar;


	public ActualizarDatosView(Integer idDuenio, String nombreDuenio, String telefono) {
		this.idDuenio = idDuenio;
		this.nombreDuenio = nombreDuenio;
		this.telefono = telefono;
		
		duenioController = new DuenioController();
		mascotaController = new MascotaController();
		
		Container container = getContentPane();
		getContentPane().setLayout(null);
		
		configurarVentanaRegistro(container);
		this.txtIdDuenio.setText(idDuenio.toString());
		this.txtNombreDuenio.setText(nombreDuenio);
		this.txtTelefono.setText(telefono);
		
		configurarBotones();
	}


	private void configurarVentanaRegistro(Container container) {
		setBounds(100, 100, 733, 577);
		panelActualizarDatos = new JPanel();
		panelActualizarDatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelActualizarDatos.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Peluquería Canina");
		lblTituloPrincipal.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setBounds(222, 0, 264, 58);
		
		panel = new JPanel();
		panel.setBounds(0, 176, 569, 340);
		panel.setLayout(null);
		
		lblAtencionEsp = new JLabel("Atención especial:");
		lblAtencionEsp.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblAtencionEsp.setBounds(6, 150, 134, 30);
		panel.add(lblAtencionEsp);

		txtAtencionEsp = new JTextArea();
		txtAtencionEsp.setColumns(10);
		txtAtencionEsp.setBounds(138, 150, 421, 84);
		panel.add(txtAtencionEsp);

		lblAlergico = new JLabel("Alérgico:");
		lblAlergico.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblAlergico.setBounds(6, 59, 67, 30);
		panel.add(lblAlergico);

		txtAlergico = new JTextArea();
		txtAlergico.setColumns(10);
		txtAlergico.setBounds(77, 59, 217, 80);
		panel.add(txtAlergico);

		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblObservaciones.setBounds(6, 245, 112, 30);
		panel.add(lblObservaciones);

		txtObservaciones = new JTextArea();
		txtObservaciones.setColumns(10);
		txtObservaciones.setBounds(138, 245, 421, 84);
		panel.add(txtObservaciones);

		cbxRaza = new JComboBox<>();
		cbxRaza.setModel(new DefaultComboBoxModel(Raza.values()));
		cbxRaza.setBounds(304, 78, 252, 22);		
		panel.add(cbxRaza);
		
	// PANEL DUEÑO:		
		panelDuenios = new JPanel();
		panelDuenios.setBounds(0, 46, 569, 131);
		panelDuenios.setLayout(null);
		
		lblNombreDuenio = new JLabel("Nombre completo del Dueño:");
		lblNombreDuenio.setBounds(117, 15, 217, 21);
		panelDuenios.add(lblNombreDuenio);
		lblNombreDuenio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		txtNombreDuenio = new JTextArea();
		txtNombreDuenio.setBounds(117, 34, 280, 20);
		panelDuenios.add(txtNombreDuenio);
		txtNombreDuenio.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(407, 15, 93, 21);
		panelDuenios.add(lblTelefono);
		lblTelefono.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		txtTelefono = new JTextArea();
		txtTelefono.setBounds(407, 34, 122, 20);
		panelDuenios.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblDireccion.setBounds(6, 65, 80, 21);
		panelDuenios.add(lblDireccion);
		
		txtDireccion = new JTextArea();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(84, 65, 475, 47);
		panelDuenios.add(txtDireccion);
		
		lblIdDuenio = new JLabel("Id Dueño:");
		lblIdDuenio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblIdDuenio.setBounds(6, 15, 93, 21);
		panelDuenios.add(lblIdDuenio);
		
		txtIdDuenio = new JTextArea();
		txtIdDuenio.setEnabled(false);
		txtIdDuenio.setEditable(false);
		txtIdDuenio.setColumns(10);
		txtIdDuenio.setBounds(6, 34, 104, 20);
		panelDuenios.add(txtIdDuenio);		
		
		lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblIdMascota.setBounds(6, 11, 93, 21);
		panel.add(lblIdMascota);
		
		txtIdMascota = new JTextArea();
		txtIdMascota.setColumns(10);
		txtIdMascota.setBounds(6, 28, 226, 20);
		panel.add(txtIdMascota);
		
		lblNombreMascota = new JLabel("Nombre Mascota:");
		lblNombreMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNombreMascota.setBounds(242, 11, 129, 21);
		panel.add(lblNombreMascota);
		
		txtNombreM = new JTextArea();
		txtNombreM.setColumns(10);
		txtNombreM.setBounds(241, 28, 318, 20);
		panel.add(txtNombreM);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblRaza.setBounds(304, 59, 67, 21);
		panel.add(lblRaza);
		
		container.add(panelDuenios);
		container.add(panelActualizarDatos);
		container.add(lblTituloPrincipal);
		container.add(panel);
		
	// BOTONES:
		panelBotonesDuenio = new JPanel();
		panelBotonesDuenio.setBounds(579, 56, 102, 96);
		getContentPane().add(panelBotonesDuenio);
		panelBotonesDuenio.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(0, 21, 89, 23);
		panelBotonesDuenio.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(0, 73, 89, 23);
		panelBotonesDuenio.add(btnEliminar);
		
		panelBotonesMascota = new JPanel();
		panelBotonesMascota.setLayout(null);
		panelBotonesMascota.setBounds(579, 190, 102, 176);
		getContentPane().add(panelBotonesMascota);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(0, 14, 89, 23);
		panelBotonesMascota.add(btnBuscar);
		
		btnGuardarM = new JButton("Guardar");
		btnGuardarM.setBounds(0, 48, 89, 23);
		panelBotonesMascota.add(btnGuardarM);
		
		btnEliminarM = new JButton("Eliminar");
		btnEliminarM.setBounds(0, 142, 89, 23);
		panelBotonesMascota.add(btnEliminarM);	
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(0, 82, 89, 23);
		panelBotonesMascota.add(btnLimpiar);
	}
	
	public void configurarBotones(){
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDuenio(idDuenio);
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarDuenio(idDuenio);	
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escogerBusqueda();
			}
		});
		
		btnGuardarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				actualizarMascota(Integer.valueOf(txtIdMascota.getText()));
			}
		});

		btnEliminarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarMascota();	
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatosMascota();	
			}
		});		
	}
	
	// Sí funciona
	public void actualizarDuenio(Integer idDuenio){
		if(txtNombreDuenio.getText().isBlank() || txtTelefono.getText().isBlank() || txtDireccion.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, String.format("Ingrese información actualizada en todos los campos"));
		}
		String nombreDuenio = txtNombreDuenio.getText();
		String telefono = txtTelefono.getText();
		String direccion = txtDireccion.getText();
		duenioController.actualizarDuenioPorId(idDuenio, nombreDuenio, telefono, direccion);
		JOptionPane.showMessageDialog(this, "¡Actualización Exitosa!");
	}
	// Sí funciona
	public void eliminarDuenio(Integer idDuenio) {
		duenioController.eliminarDuenioPorId(idDuenio);
		JOptionPane.showMessageDialog(this, String.format("Se eliminó al Dueño"));
	}
	//Sí funciona
	public void escogerBusqueda() {
		if(txtIdMascota.getText().isBlank() || txtIdDuenio.getText().isBlank() || !txtNombreM.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, String.format("Se requiere Id del Bueño y Id o Nombre de Mascota"));
		}
		if(!txtIdDuenio.getText().isBlank() && !txtIdMascota.getText().isBlank()) {
			buscarMascotaPorIds(idDuenio);					
		}else{
			buscarMascotaPorIdYNombreMascota(idDuenio);
		}
	}
	
	// Sí funciona
	public void buscarMascotaPorIds(Integer idDuenio){
		Integer idMascota = Integer.parseInt(txtIdMascota.getText().toString());
		var mascota = mascotaController.buscarMascotaPorIds(idDuenio, idMascota);
		if(mascota != null) {
			txtNombreM.setText(mascota.getNombreMascota());
			txtIdMascota.setEditable(false);
		}else {
			JOptionPane.showMessageDialog(this, String.format("No se encontró Mascota con esos datos"));
		}	
	}
	//Sí funciona
	public void buscarMascotaPorIdYNombreMascota(Integer idDuenio){		
		String nombreMascota = txtNombreM.getText();
		var mascota = mascotaController.buscarMascotaPorIdDYNombreM(idDuenio, nombreMascota);
		if(mascota != null) {
			txtIdMascota.setText(mascota.getIdMascota().toString());
			txtIdMascota.setEditable(false);
			
		}else {
			JOptionPane.showMessageDialog(this, String.format("No se encontró Mascota con esos datos"));
		}
		
	}
	// Sí funciona
	public void actualizarMascota(Integer idMascota){
		if(txtNombreDuenio.getText().isBlank() || txtTelefono.getText().isBlank() || txtDireccion.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, String.format("Ingrese todos los datos del Dueño"));
		}
		if(txtIdMascota.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, String.format("Ingrese el Id de la Mascota"));
		}
		String nombreM = txtNombreM.getText();
		String alergico = txtAlergico.getText();
		String atencionEsp = txtAtencionEsp.getText();
		String observaciones = txtObservaciones.getText();
		String raza = cbxRaza.getSelectedItem().toString();
		
		mascotaController.actualizarMascota(idMascota, nombreM, alergico, atencionEsp, observaciones, raza);
		JOptionPane.showMessageDialog(this, "¡Actualización Exitosa!");
	}
	// Sí funciona
	public void eliminarMascota(){
		if(txtIdMascota.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, String.format("Ingrese el Id de la Mascota"));
		}
		mascotaController.eliminarMascota(txtIdMascota.getText().toString());
		JOptionPane.showMessageDialog(this, "Mascota eliminada del registro");
	}
	// Sí funciona
	public void limpiarDatosMascota() {
		this.txtIdMascota.setEditable(true);
		this.txtIdMascota.setText("");
		this.txtNombreM.setText("");
		this.txtAlergico.setText("");
		this.txtAtencionEsp.setText("");
		this.txtObservaciones.setText("");
		this.cbxRaza.setSelectedIndex(0);
	}
	
}
