package frsf.cidisi.exercise.tpia2016.interfaz;

import java.awt.*;

import javax.swing.*;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -350495874541679559L;
	JPanel panelGrafico;
	JButton ejecutar;
	
	

	public Principal(Edificio mapa) {
		super();
		this.inicializar();
	}

	private void inicializar() {
		setSize(600, 450);
		setVisible(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(3);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Agente Guia");
//		this.ejecutar = new JButton("Ejecutra");
//		add(ejecutar);
	}



	public void paint(Graphics g) {
		 g.setColor(Color.RED);
	}

}
