package com.mycompany.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import com.mycompany.controller.CitaController;
import com.mycompany.controller.DuenioController;
import com.mycompany.controller.MascotaController;
import com.mycompany.factory.ConnectionFactory;
import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.mascota.Mascota;
import com.mycompany.modelo.mascota.Raza;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import javax.swing.DefaultComboBoxModel;

public class RevisarAgendaView extends JFrame {

	private JPanel panelAgenda, panel, panel_1;
	private JLabel lblTituloPrincipal, lblIdMascota, lblRaza, lblNombreMascota,
				   lblIdDuemio, lblTeléfono, lblIconoMascota, lblDuemio, lblProximaCita, lblEscogerFecha;
	private JTextArea txtIdMascota, txtNombreMascota, txtIdDuenio, txtTelefono, txtNombreD;
	private JComboBox cbxRaza, cbxHora;
	private JButton btnBuscar, btnLimpiar, btnEliminar, btnModificar, btnGuardar;
	private JTextField txtProximaCita;
	
	private JDateChooser calendario;
	private JDayChooser dayChooser;
	
	private CitaController citaController;
	private MascotaController mascotaController;
	private Raza raza;
	private JTextField txtIdCita;

	
	public RevisarAgendaView() {
		Container container = getContentPane();
        getContentPane().setLayout(null);
        setTitle("Peluqueria Canina - Agenda -");
        setLocationRelativeTo(null);
        
        citaController = new CitaController();
        mascotaController = new MascotaController();
		
        configurarCamposVentana(container);
        
        configurarBotones(container);
	}
	
	
	public void configurarCamposVentana(Container container) {
		setBounds(100, 100, 766, 351);
		panelAgenda = new JPanel();
		panelAgenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAgenda.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Peluquería Canina");
		lblTituloPrincipal.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setBounds(234, 0, 264, 79);
		ImageIcon imagenMascota = new ImageIcon("media/calendar_3.png");
		
		lblIconoMascota = new JLabel();
		lblIconoMascota.setBounds(546, 148, 155, 137);
		container.add(lblIconoMascota);
		Icon iconoMascota = new ImageIcon(imagenMascota.getImage().getScaledInstance(lblIconoMascota.getWidth(), lblIconoMascota.getHeight(), Image.SCALE_DEFAULT));
		lblIconoMascota.setIcon(iconoMascota);
		container.add(panelAgenda);
		container.add(lblTituloPrincipal);
		
		panel = new JPanel();
		panel.setBounds(10, 46, 653, 270);
		panel.setLayout(null);
		
		lblIdMascota = new JLabel("No.Id:");
		lblIdMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblIdMascota.setBounds(0, 44, 47, 30);
		panel.add(lblIdMascota);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblRaza.setBounds(399, 44, 47, 30);
		panel.add(lblRaza);
				
				txtIdMascota = new JTextArea();
				txtIdMascota.setBounds(49, 46, 98, 20);
				panel.add(txtIdMascota);
				txtIdMascota.setColumns(10);
				
				txtNombreMascota = new JTextArea();
				txtNombreMascota.setColumns(10);
				txtNombreMascota.setBounds(221, 46, 170, 20);
				panel.add(txtNombreMascota);
				
				lblNombreMascota = new JLabel("Mascota:");
				lblNombreMascota.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				lblNombreMascota.setBounds(157, 44, 67, 30);
				panel.add(lblNombreMascota);
				
				cbxRaza = new JComboBox();
				cbxRaza.setBounds(441, 45, 167, 22);
				cbxRaza.setModel(new DefaultComboBoxModel(Raza.values()));
				panel.add(cbxRaza);
				
				lblIdDuemio = new JLabel("No. Dueño:");
				lblIdDuemio.setBounds(0, 11, 90, 30);
				panel.add(lblIdDuemio);
				lblIdDuemio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				
				txtIdDuenio = new JTextArea();
				txtIdDuenio.setBounds(84, 13, 86, 20);
				panel.add(txtIdDuenio);
				txtIdDuenio.setColumns(10);
				
				lblDuemio = new JLabel("Dueño:");
				lblDuemio.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				lblDuemio.setBounds(180, 11, 80, 30);
				panel.add(lblDuemio);
				
				txtNombreD = new JTextArea();
				txtNombreD.setColumns(10);
				txtNombreD.setBounds(236, 13, 181, 20);
				panel.add(txtNombreD);
				
				lblTeléfono = new JLabel("Teléfono:");
				lblTeléfono.setBounds(427, 11, 74, 30);
				panel.add(lblTeléfono);
				lblTeléfono.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				
				txtTelefono = new JTextArea();
				txtTelefono.setBounds(496, 13, 112, 20);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
				
	//BOTONES:			
				lblProximaCita = new JLabel("Proxima Cita:");
				lblProximaCita.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				lblProximaCita.setBounds(0, 85, 112, 30);
				panel.add(lblProximaCita);
				
				txtProximaCita = new JTextField();
				txtProximaCita.setColumns(10);
				txtProximaCita.setBounds(98, 85, 258, 30);
				panel.add(txtProximaCita);
				container.add(panel);
				
				panel_1 = new JPanel();
				panel_1.setBounds(389, 78, 119, 172);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				btnModificar = new JButton("Modificar");
				btnModificar.setBounds(0, 45, 109, 23);
				panel_1.add(btnModificar);
				
				btnLimpiar = new JButton("Limpiar");
				btnLimpiar.setBounds(0, 93, 109, 23);
				panel_1.add(btnLimpiar);
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(0, 140, 89, 23);
				panel_1.add(btnEliminar);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(0, 11, 109, 23);
				panel_1.add(btnGuardar);
				
				calendario = new JDateChooser();
				calendario.setBounds(98, 170, 119, 20);
				calendario.setDateFormatString("yyyy-MM-dd");
				panel.add(calendario);
				
				dayChooser = new JDayChooser();
				dayChooser.setBounds(-83, 156, -75, 56);
				panel.add(dayChooser);
				
				lblEscogerFecha = new JLabel("Agendar cita:");
				lblEscogerFecha.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				lblEscogerFecha.setBounds(0, 170, 103, 30);
				panel.add(lblEscogerFecha);
				
				cbxHora = new JComboBox();
				cbxHora.setModel(new DefaultComboBoxModel(new String[] {"- HORARIO -", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00"}));
				cbxHora.setBounds(227, 168, 103, 22);
				panel.add(cbxHora);			
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(267, 126, 89, 23);
				panel.add(btnBuscar);
				
				JLabel lblIdCita = new JLabel("Id Cita:");
				lblIdCita.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
				lblIdCita.setBounds(0, 126, 58, 30);
				panel.add(lblIdCita);
				
				txtIdCita = new JTextField();
				txtIdCita.setColumns(10);
				txtIdCita.setBounds(59, 126, 181, 20);
				panel.add(txtIdCita);
	}
	
	public void configurarBotones(Container container) {
	
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCita();
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCita();
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				modificarCita();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});		
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();				
			}
		});
		
	}

// MÉTODOS:	
	public void guardarCita() {
		if(txtIdMascota.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Ingrese Id de la Mascota");
			}else {
				Integer idMascota = Integer.valueOf(txtIdMascota.getText());
				var mascota = mascotaController.buscarPorIdMascConDueActivo(idMascota);
				
				if(mascota == null) {
					JOptionPane.showMessageDialog(this, "Error: La Mascota no tiene Dueño Activo");	
				}else {
					validarRegistroCitas(mascota);
					txtNombreMascota.setText(mascota.getNombreMascota());
				}
			}
	}	
	public void validarRegistroCitas(Mascota mascota) {
		Integer hora = cbxHora.getSelectedIndex();
		Integer idMascota = mascota.getIdMascota();
		String f1 = ((JTextField)calendario.getDateEditor().getUiComponent()).getText();
		
		if(f1.isBlank() && hora == 0){
			JOptionPane.showMessageDialog(this, "Ingrese una Fecha y Hora para la cita");
		}else{
					
			StringBuilder fechaHora = new StringBuilder(f1 + "T" + cbxHora.getSelectedItem().toString()+":00");
			String fYH = fechaHora.toString();
			
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
			LocalDateTime fechaYHoraLD = LocalDateTime.parse(fYH);
			
			if(fechaYHoraLD != null) {
				var cita = citaController.buscarCitaActivaPorFechaYIdMasc(fechaYHoraLD, idMascota);
				if(cita == null) {
					guardar(idMascota, fechaYHoraLD);
					
					calendario.setDateFormatString(formato.format(fechaYHoraLD));
				}else {
					JOptionPane.showMessageDialog(this, "Ya existe una Cita para la Mascota en ese día");
				}
			}
		}	
	}
	public void guardar(Integer idMascota, LocalDateTime fechaYHora) {		
		
		if(idMascota != null && fechaYHora != null) {
			var cita = new Cita(idMascota, fechaYHora);
			citaController.agendarCita(cita);
			String idCitaGenerada = cita.getIdCita().toString();
			
			JOptionPane.showMessageDialog(this, "¡Registro exitoso! Cita no.: " + idCitaGenerada);
		}
	}
	
	
	public void buscarCita(){
		boolean camposVacios = false;
		if(txtIdDuenio.getText().isBlank() && txtNombreD.getText().isBlank() && 
			txtIdMascota.getText().isBlank() && txtNombreMascota.getText().isBlank() && 
			txtIdCita.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Ingrese el Id de la Cita - Ingrese Id y Nombre del Dueño y de la Mascota");
		}
		
		if(!txtIdDuenio.getText().isBlank() && !txtNombreMascota.getText().isBlank()) {
			buscarPorIdDuenioYNombreMascota();
		}
		if(!txtIdDuenio.getText().isBlank() && !txtIdMascota.getText().isBlank()) {
			buscarPorIds();
		}
		if(!txtNombreD.getText().isBlank() && !txtIdMascota.getText().isBlank()) {
			buscarPorNombreDuenioYIdMascota();
		}
		if(!txtIdCita.getText().isBlank()) {
			buscarIdCita();
		}
		if(!txtIdDuenio.getText().isBlank() && !txtNombreD.getText().isBlank() && !txtTelefono.getText().isBlank() && !txtIdMascota.getText().isBlank() &&
				!txtNombreMascota.getText().isBlank() && !cbxRaza.getSelectedItem().toString().isBlank() &&	!txtProximaCita.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Cita encontrada!");
		}		
	}
    // TIPOS DE BUSQUEDA------>	
	public void buscarPorIdDuenioYNombreMascota(){		
		Integer idDuenio = Integer.valueOf(txtIdDuenio.getText());
		String nombreMascota = txtNombreMascota.getText();
		var cita = citaController.buscarIdDuenioYNombreMascota(idDuenio, nombreMascota);
		
		if(cita == null) {
			JOptionPane.showMessageDialog(this, "No hay registro de Mascota con esos datos");
		}else {
			txtNombreD.setText(cita.getDuenio().getNombreDuenio());
			txtTelefono.setText(cita.getDuenio().getTelefono());
			
			txtIdMascota.setText(cita.getIdMascota().toString());			
			cbxRaza.setSelectedItem((cita.getMascota().getRaza()));
			
			txtProximaCita.setText(cita.getCitaAgendada().toString());
			txtIdCita.setText(cita.getIdCita().toString());			
		}
	}		
	public void buscarPorIds(){
		Integer idDuenio = Integer.valueOf(txtIdDuenio.getText());
		Integer idMascota= Integer.valueOf(txtIdMascota.getText());
		var cita = citaController.buscarPorIds(idDuenio, idMascota);
		
		if(cita == null) {
			JOptionPane.showMessageDialog(this, "No hay registro de Mascota con esos datos");
		}else {
			txtNombreD.setText(cita.getDuenio().getNombreDuenio());
			txtTelefono.setText(cita.getDuenio().getTelefono());
			
			txtNombreMascota.setText(cita.getMascota().getNombreMascota());			
			cbxRaza.setSelectedItem((cita.getMascota().getRaza()));
			
			txtProximaCita.setText(cita.getCitaAgendada().toString());
			txtIdCita.setText(cita.getIdCita().toString());

		}
	}
	public void buscarPorNombreDuenioYIdMascota(){
		String nombreDuenio = txtNombreD.getText();
		Integer idMascota= Integer.valueOf(txtIdMascota.getText());		
		var cita = citaController.buscarPorNombreDuenioYIdMascota(nombreDuenio, idMascota);
		
		if(cita == null) {
			JOptionPane.showMessageDialog(this, "No hay registro de Mascota con esos datos");
		}else {
			txtIdDuenio.setText(cita.getDuenio().getIdDuenio().toString());
			txtTelefono.setText(cita.getDuenio().getTelefono());
			
			txtNombreMascota.setText(cita.getIdMascota().toString());			
			cbxRaza.setSelectedItem((cita.getMascota().getRaza()));
			
			txtProximaCita.setText(cita.getCitaAgendada().toString());
			txtIdCita.setText(cita.getIdCita().toString());
		}	
		
	}
	public void buscarIdCita(){
		Integer idCita= Integer.valueOf(txtIdCita.getText());
		var cita = citaController.buscarPorIdCita(idCita);
		
		if(cita == null) {
			JOptionPane.showMessageDialog(this, "No hay registro de Mascota con esos datos");
		}else {
			txtIdDuenio.setText(cita.getDuenio().getIdDuenio().toString());
			txtNombreD.setText(cita.getDuenio().getNombreDuenio());
			txtTelefono.setText(cita.getDuenio().getTelefono());
			
			txtIdMascota.setText(cita.getIdMascota().toString());
			txtNombreMascota.setText(cita.getIdMascota().toString());			
			cbxRaza.setSelectedItem((cita.getMascota().getRaza()));
			
			txtProximaCita.setText(cita.getCitaAgendada().toString());
			}
	}
		
	public void modificarCita(){													//FUNCIONA
		if(txtIdCita.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Ingrese Id de la Cita");		
		}else {
			Integer idCita = Integer.valueOf(txtIdCita.getText());
			var cita = citaController.buscarPorIdCita(idCita);
			if(cita != null) {
				String fYH = new StringBuilder(((JTextField)calendario.getDateEditor().getUiComponent()).getText()
											+ "T" + cbxHora.getSelectedItem().toString() + ":00").toString(); 
				LocalDateTime fechaYHora = LocalDateTime.parse(fYH);
				if(fechaYHora == null) {
					JOptionPane.showMessageDialog(this, "Ingrese datos de Fecha y Hora");
				}else {
					citaController.modificarCita(idCita, fechaYHora);
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
					calendario.setDateFormatString(formato.format(fechaYHora));
					JOptionPane.showMessageDialog(this, "¡La Cita fue modificada!");
				}
			}
		}
	}
	
	public void eliminar() {
		if(txtIdCita.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Ingrese Id de la Cita");		
		}else {
			Integer idCita = Integer.valueOf(txtIdCita.getText());
			var cita = citaController.buscarPorIdCita(idCita);
			if(cita != null) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la Cita agendada?");
				if(respuesta == 0) {
					citaController.eliminarCita(idCita);
					JOptionPane.showMessageDialog(this, "La Cita fue eliminada");
					limpiar();
				}
			}
		}	
	}

	
	public void limpiar() {
		txtIdDuenio.setText("");
		txtNombreD.setText("");
		txtTelefono.setText("");
		txtIdMascota.setText("");
		txtNombreMascota.setText("");
		cbxRaza.setSelectedIndex(0);
		txtProximaCita.setText("");
		calendario.setDateFormatString("");;
		cbxHora.setSelectedIndex(0);
		txtIdCita.setText("");		
	}
	
}

	
