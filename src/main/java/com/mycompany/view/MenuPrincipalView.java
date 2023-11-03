package com.mycompany.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuPrincipalView extends JFrame {

	private JPanel panelPrincipal, panel;
	private JLabel lblTituloPrincipal, lblIconoMascota;
	private JButton btnDatosMascotas, btnRegistroDatos, btnSalir;

	
	public MenuPrincipalView() {
		generarMenuPrincipal();
		setTitle("Peluqueria Canina - Menú Principal -");
		}

	private void generarMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 449);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Peluquería Canina");
		lblTituloPrincipal.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setBounds(214, 11, 264, 70);
		panelPrincipal.add(lblTituloPrincipal);
		
		panel = new JPanel();
		panel.setBounds(10, 68, 337, 298);
		panelPrincipal.add(panel);
		panel.setLayout(null);
		
		btnDatosMascotas = new JButton("Revisar Agenda");
		btnDatosMascotas.setBounds(57, 24, 228, 51);
		panel.add(btnDatosMascotas);
		
		btnRegistroDatos = new JButton("Nuevos Registros");
		btnRegistroDatos.setBounds(57, 115, 228, 51);
		panel.add(btnRegistroDatos);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(57, 204, 228, 51);
		panel.add(btnSalir);
		
		
		lblIconoMascota = new JLabel();
		lblIconoMascota.setLocation(347, 110);
		lblIconoMascota.setSize(253, 194);
		ImageIcon imagenMascota = new ImageIcon("media/pomeranian.png");
		Icon iconoMascota = new ImageIcon(imagenMascota.getImage().getScaledInstance(lblIconoMascota.getWidth(), lblIconoMascota.getHeight(), Image.SCALE_DEFAULT));
		lblIconoMascota.setIcon(iconoMascota);
		panelPrincipal.add(lblIconoMascota);
		
		abrirNuevoRegistro();
		abrirRevisarAgenda();
	
	}
	
	public void abrirNuevoRegistro() {
		btnRegistroDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarDatosView ventanaRegistrarDatos = new RegistrarDatosView();
				ventanaRegistrarDatos.setVisible(true);
				ventanaRegistrarDatos.setLocationRelativeTo(null);
			}
		});	
	}
	
	public void abrirRevisarAgenda() {
		btnDatosMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RevisarAgendaView ventanaRevisarAgenda = new RevisarAgendaView();
				ventanaRevisarAgenda.setVisible(true);
				ventanaRevisarAgenda.setLocationRelativeTo(null);
				}
		});	
	}
	
}
