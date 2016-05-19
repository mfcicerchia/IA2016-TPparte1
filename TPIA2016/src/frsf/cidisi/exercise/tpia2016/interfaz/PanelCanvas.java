package frsf.cidisi.exercise.tpia2016.interfaz;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelCanvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int posicionX;
	int posicionY;

	private Image fondo;
	private Image agente;
	

	public PanelCanvas() {
		inicializarImagenFondo();
	}

	private void inicializarImagenFondo() {
		fondo = new ImageIcon("images\\fondo.png").getImage();
		agente = new ImageIcon("images\\ok.png").getImage();
	}

	public void paintComponent(Graphics g) {
		updateUI();
		repaint();
		g.setColor(Color.black);
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(agente, posicionX , posicionY, 20, 20, this);
		g.drawString( "" + posicionX + ", " + posicionY, posicionX,posicionY );
		repaint();
	}

	public Image getFondo() {
		return fondo;
	}

	public void dibujarAgente(Graphics g) {
		g.drawImage(agente, posicionX , posicionY, 20, 20, this);
	}
	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}
	
}