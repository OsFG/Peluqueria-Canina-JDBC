package com.mycompany;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.mycompany.view.MenuPrincipalView;
import com.mycompany.view.RegistrarDatosView;


public class PeluqCaninaApp{
	
    public static void main( String[] args ){
    
    	MenuPrincipalView menuPrincipal = new MenuPrincipalView();
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalView frame = new MenuPrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
}
