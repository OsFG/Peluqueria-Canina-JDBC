package com.mycompany.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mycompany.controller.DuenioController;
import com.mycompany.controller.MascotaController;
import com.mycompany.modelo.duenio.Duenio;
import com.mycompany.modelo.mascota.Mascota;
import com.mycompany.modelo.mascota.Raza;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarDatosView extends JFrame {

	private JPanel panelRegistro, panel, panel_1, panel_2;
	private JTextArea textNombreMascota, txtAlergico, txtColor, txtAtencionEsp, txtNombreDuenio, txtIdDuenio, txtTelefono, txtObservaciones, txtDireccion;
	private JLabel lblTituloPrincipal, lblRaza, lblColor, lblAlergico, lblAtencionEsp, lblObservaciones, lblNombreMascota, lblNombreDuenio, lblIdDuenio,
				   lblTelefono, lblDireccion, lblIconoHuella, lblIconoGente;
	private JComboBox<Raza> cbxRaza;
	private JButton btnRegistrar, btnLimpiar, btnActualizar, btnBuscar;
	private JRadioButton rdBtnRegistrarMascota;
	
	private boolean botonActivado = false;

	private MascotaController mascotaController;
	private DuenioController duenioController;
	private JLabel lblIdMascota;
	private JTextArea txtIdMascota;
	
	public RegistrarDatosView() {
		Container container = getContentPane();
        getContentPane().setLayout(null);
		configurarCamposVentanaRegistro(container);
		configurarAccionesBotones();
		
		setTitle("Peluqueria Canina - Nuevo Registro -");
		setVisible(true);
		setLocationRelativeTo(null);
		
		this.mascotaController = new MascotaController();
		this.duenioController = new DuenioController();
			
	}


	private void configurarCamposVentanaRegistro(Container container) {
		setBounds(100, 100, 843, 683);
		panelRegistro = new JPanel();
		panelRegistro.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelRegistro.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Peluquería Canina");
		lblTituloPrincipal.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setBounds(274, 0, 264, 55);
		
		panel = new JPanel();
		panel.setBounds(10, 46, 413, 429);
		panel.setLayout(null);
		

		lblNombreMascota = new JLabel("Nombre:");
		lblNombreMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNombreMascota.setBounds(0, 11, 67, 30);
		panel.add(lblNombreMascota);
		
		textNombreMascota = new JTextArea();
		textNombreMascota.setEnabled(botonActivado);
		textNombreMascota.setColumns(10);
		textNombreMascota.setBounds(66, 13, 327, 20);
		panel.add(textNombreMascota);
		
		lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblIdMascota.setBounds(0, 45, 90, 30);
		panel.add(lblIdMascota);
		
		txtIdMascota = new JTextArea();
		txtIdMascota.setEditable(false);
		txtIdMascota.setEnabled(false);
		txtIdMascota.setColumns(10);
		txtIdMascota.setBounds(87, 47, 306, 20);
		panel.add(txtIdMascota);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblRaza.setBounds(0, 111, 47, 30);
		panel.add(lblRaza);
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblColor.setBounds(0, 78, 47, 30);
		panel.add(lblColor);
		
		lblAlergico = new JLabel("Alérgico:");
		lblAlergico.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblAlergico.setBounds(0, 150, 67, 30);
		panel.add(lblAlergico);
		
		lblAtencionEsp = new JLabel("Atención especial:");
		lblAtencionEsp.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblAtencionEsp.setBounds(0, 180, 134, 30);
		panel.add(lblAtencionEsp);
		
		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblObservaciones.setBounds(0, 303, 112, 30);
		panel.add(lblObservaciones);
		
		txtAlergico = new JTextArea();
		txtAlergico.setEnabled(botonActivado);
		txtAlergico.setColumns(10);
		txtAlergico.setBounds(76, 152, 317, 20);
		panel.add(txtAlergico);
		
		txtColor = new JTextArea();
		txtColor.setEnabled(botonActivado);
		txtColor.setColumns(10);
		txtColor.setBounds(48, 78, 345, 20);
		panel.add(txtColor);
		
		txtAtencionEsp = new JTextArea();
		txtAtencionEsp.setEnabled(botonActivado);
		txtAtencionEsp.setColumns(10);
		txtAtencionEsp.setBounds(10, 209, 393, 92);
		panel.add(txtAtencionEsp);
		
		cbxRaza = new JComboBox<>();
		cbxRaza.setEnabled(botonActivado);
		cbxRaza.setModel(new DefaultComboBoxModel(Raza.values()));
		cbxRaza.setBounds(48, 112, 345, 22);		
		panel.add(cbxRaza);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setEnabled(botonActivado);
		txtObservaciones.setColumns(10);
		txtObservaciones.setBounds(10, 330, 393, 99);
		panel.add(txtObservaciones);
		
	// PANEL BOTONES 	
		panel_1 = new JPanel();
		panel_1.setBounds(414, 545, 389, 55);
		panel_1.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(32, 5, 109, 35);
		panel_1.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(151, 5, 109, 35);
		panel_1.add(btnLimpiar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(270, 5, 109, 35);
		panel_1.add(btnActualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(299, 56, 80, 23);
		
	// PANEL DUEÑO:		
		panel_2 = new JPanel();
		panel_2.setBounds(428, 46, 389, 297);
		panel_2.setLayout(null);
		
		lblNombreDuenio = new JLabel("Nombre completo del Dueño:");
		lblNombreDuenio.setBounds(0, 11, 217, 21);
		panel_2.add(lblNombreDuenio);
		lblNombreDuenio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		txtNombreDuenio = new JTextArea();
		txtNombreDuenio.setBounds(0, 30, 379, 20);
		panel_2.add(txtNombreDuenio);
		txtNombreDuenio.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(188, 71, 64, 21);
		panel_2.add(lblTelefono);
		lblTelefono.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		txtTelefono = new JTextArea();
		txtTelefono.setBounds(188, 96, 191, 20);
		panel_2.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblDireccion.setBounds(0, 131, 80, 21);
		panel_2.add(lblDireccion);
		
		txtDireccion = new JTextArea();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(0, 155, 379, 110);
		panel_2.add(txtDireccion);
		
		lblIdDuenio = new JLabel("Id Dueño:");
		lblIdDuenio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblIdDuenio.setBounds(0, 71, 93, 21);
		panel_2.add(lblIdDuenio);
		
		txtIdDuenio = new JTextArea();
		txtIdDuenio.setEnabled(false);
		txtIdDuenio.setEditable(false);
		txtIdDuenio.setColumns(10);
		txtIdDuenio.setBounds(0, 96, 178, 20);
		panel_2.add(txtIdDuenio);
		
		panel_2.add(btnBuscar);
		
		rdBtnRegistrarMascota = new JRadioButton("Registrar Mascota");
		rdBtnRegistrarMascota.setSelected(false);		
		rdBtnRegistrarMascota.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdBtnRegistrarMascota.setBounds(6, 270, 144, 23);
		panel_2.add(rdBtnRegistrarMascota);
		

	// ICONOS
		lblIconoHuella = new JLabel();
		lblIconoHuella.setLocation(126, 481);
		lblIconoHuella.setSize(173, 139);
		ImageIcon imagenHuella = new ImageIcon("media/huella.png");
		Icon iconoHuella = new ImageIcon(imagenHuella.getImage().getScaledInstance(lblIconoHuella.getWidth(), lblIconoHuella.getHeight(), Image.SCALE_DEFAULT));
		lblIconoHuella.setIcon(iconoHuella);
		
		
		lblIconoGente = new JLabel();
		lblIconoGente.setLocation(474, 354);
		lblIconoGente.setSize(279, 175);
		ImageIcon imagenGente = new ImageIcon("media/gente.png");
		Icon iconoPersonas = new ImageIcon(imagenGente.getImage().getScaledInstance(lblIconoGente.getWidth(), lblIconoGente.getHeight(), Image.SCALE_DEFAULT));
		lblIconoGente.setIcon(iconoPersonas);
		
		container.add(lblTituloPrincipal);
		container.add(panelRegistro);
		container.add(panel);
		container.add(panel_1);
		container.add(panel_2);		
		container.add(lblIconoHuella);
		container.add(lblIconoGente);
		
	}
	
		
	private void configurarAccionesBotones() {
		btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();                
            }
        });
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();				
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					avisoDatosDuenio();
			}
		});
		
		rdBtnRegistrarMascota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdBtnRegistrarMascota.isSelected()) {
					botonActivado = true;
					activarFormularioMascota(botonActivado);	
				}else {
					botonActivado = false;
					limpiar2();
					activarFormularioMascota(botonActivado);
				}
			}
		}); 
		
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				buscarDuenio();
			}
			
		});					
	}
	
	private void buscarDuenio(){
		if(txtNombreDuenio.getText().isBlank() || txtTelefono.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Se necesitan el Nombre completo y Teléfono del Dueño");
            return;
		}
		String nombreDuenio = txtNombreDuenio.getText();
		String telDuenio = txtTelefono.getText();
		var duenioBuscado = duenioController.buscarDuenioPorNombreYTelefono(nombreDuenio, telDuenio);
		if(duenioBuscado != null) {
			JOptionPane.showMessageDialog(this, "¡Registro Encontrado!");

			txtTelefono.setText(duenioBuscado.getTelefono());
			txtDireccion.setText(duenioBuscado.getDireccion());
			txtIdDuenio.setText(duenioBuscado.getIdDuenio().toString()); 
			
		}else {
			JOptionPane.showMessageDialog(this, "No existe un registro con esos datos");
		}
	}
	
	private void guardar() {
		if (txtNombreDuenio.getText().isBlank() || txtTelefono.getText().isBlank() || txtDireccion.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "No se han ingresado datos del Dueño");
            return;
        }
		
/* METODO DUENIO-DAO PARA BUSCAR POR NOMBRE Y OBTENER ID ;
 		   SI HAY UN REGISTRO, LANZARÁ UNA ALERTA Y USARÁ LOS DATOS DEL REGISTRO + ACTIVAR REGISTRO DE MASCOTA
		   SI NO HAY REGISTRO, VA A GUARDAR LOS DATOS INGRESADOS EN EL VIEW + ACTIVAR REGISTRO DE MASCOTA*/		   
		Duenio duenio;
		Integer idDuenio;
		boolean activarRegistroMascota = false;
		
		String nombreDuenio = txtNombreDuenio.getText();
		String telDuenio = txtTelefono.getText();
		var duenioBuscado = duenioController.buscarDuenioPorNombreYTelefono(nombreDuenio, telDuenio);
		if(duenioBuscado == null) {
			String direccion = txtDireccion.getText();
			
			duenio = new Duenio(nombreDuenio, telDuenio, direccion);
			this.duenioController.guardar(duenio);
			idDuenio = duenio.getIdDuenio();
			txtIdDuenio.setText(idDuenio.toString());
			limpiar();
			
		}else {
			JOptionPane.showMessageDialog(this, "Ya existe un Dueño registrado con este Nombre");
			JOptionPane.showMessageDialog(this, "Se van a emplear los datos del registro");
			txtTelefono.setText(duenioBuscado.getTelefono());
			txtDireccion.setText(duenioBuscado.getDireccion());
			txtIdDuenio.setText(duenioBuscado.getIdDuenio().toString());
		}
		
		
		if (botonActivado == true) {
			if (textNombreMascota.getText().isBlank() || txtColor.getText().isBlank() || cbxRaza.getSelectedItem().equals("SELECCIONAR_RAZA") || 
					txtAlergico.getText().isBlank() || txtAtencionEsp.getText().isBlank() || txtObservaciones.getText().isBlank()){
		            JOptionPane.showMessageDialog(this, "Especifique todos los datos de la Mascota");	
		            return;
		        }
			
			Mascota mascota;
	    	String nombre = textNombreMascota.getText();	    	
	    	var mascotaBuscada = mascotaController.buscarMascotaPorNombreMascotaIdDuenio(nombre, Integer.valueOf(txtIdDuenio.getText()));
	    	
			if(mascotaBuscada == null) {
				String color = txtColor.getText();
				String raza = cbxRaza.getSelectedItem().toString();
				String alergico = txtAlergico.getText();
				String atencionEsp = txtAtencionEsp.getText();
				String observaciones = txtObservaciones.getText();
				Integer idDuenioTxt = Integer.valueOf(txtIdDuenio.getText());
				
				mascota = new Mascota(nombre, color, raza, alergico, atencionEsp, observaciones, idDuenioTxt);
				this.mascotaController.guardar(mascota);
				txtIdMascota.setText(mascota.getIdMascota().toString());
				
				JOptionPane.showMessageDialog(this, "¡Registro exitoso!");
				this.limpiar();
			}else {
				JOptionPane.showMessageDialog(this, "Ya existe una Mascota registrado con este Nombre");
				txtIdMascota.setText(mascotaBuscada.getIdMascota().toString());
				cbxRaza.setSelectedItem(mascotaBuscada.getRaza());
				txtAlergico.setText(mascotaBuscada.getAlergico());
				txtAtencionEsp.setText(mascotaBuscada.getAtencionEspecial());				
			}    
		}
		
					
	}
	
	private void limpiar() {
		this.txtNombreDuenio.setText("");
		this.txtTelefono.setText("");
		this.txtDireccion.setText("");
		this.textNombreMascota.setText("");
		this.txtColor.setText("");
		this.cbxRaza.setSelectedIndex(0);
		this.txtAlergico.setText("");
		this.txtAtencionEsp.setText("");
		this.txtObservaciones.setText("");
		this.txtIdDuenio.setText("");
		this.txtIdMascota.setText("");
	}
	
	private void limpiar2(){
		this.textNombreMascota.setText("");
		this.txtColor.setText("");
		this.cbxRaza.setSelectedIndex(0);
		this.txtAlergico.setText("");
		this.txtAtencionEsp.setText("");
		this.txtObservaciones.setText("");	
	}
	
	private void activarFormularioMascota(boolean botonActivado) {
		textNombreMascota.setEnabled(botonActivado);
		txtColor.setEnabled(botonActivado);
		cbxRaza.setEnabled(botonActivado);
		txtAlergico.setEnabled(botonActivado);
		txtAtencionEsp.setEnabled(botonActivado);
		txtObservaciones.setEnabled(botonActivado);
	}
	
	private void avisoDatosDuenio() {
		if(txtIdDuenio.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Es necesario realizar busqueda previa del Dueño");
			return;
		}else {
			Integer idDuenio = Integer.parseInt(txtIdDuenio.getText().toString());
			String nombreDuenio = txtNombreDuenio.getText();
			String tel = txtTelefono.getText();
			ActualizarDatosView ventanaActualizarDatos = new ActualizarDatosView(idDuenio, nombreDuenio, tel);
			ventanaActualizarDatos.setVisible(true);
		}
	}
}
