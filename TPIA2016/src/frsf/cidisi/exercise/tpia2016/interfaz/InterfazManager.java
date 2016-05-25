package frsf.cidisi.exercise.tpia2016.interfaz;

import java.awt.Point;
import frsf.cidisi.exercise.tpia2016.search.AgenteEjecutar;
import frsf.cidisi.exercise.tpia2016.search.EstadoAgente;
import frsf.cidisi.exercise.tpia2016.search.EstadoAmbiente;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class InterfazManager {
	
	// Numeracion de los tipos de busqueda disponibles
	public static final int BUSQUEDA_ANCHURA 			= 0;
	public static final int BUSQUEDA_PROFUNDIDAD 		= 1;
	public static final int BUSQUEDA_COSTO_UNIFORME 	= 2;
	public static final int BUSQUEDA_AVARA				= 3;
	
	private static InterfazSimulator simulador;
	private static PanelSimulador window;
	private static Timer autoStep;
	private static int busquedaAct;
	Edificio edificio;
	Habitacion origen;
	Habitacion destino;
	EstadoAgente estag;
	EstadoAmbiente estamb;
	int estrategia;
	int energia;
	static String idIngreso;
	
	public static void comenzarSimulador(Edificio mapaAmbiente,Edificio mapaAgente , int energía, Habitacion post,Habitacion dest, int estrategia, String idg) {
		busquedaAct = estrategia;
		idIngreso=idg;
		switch(busquedaAct){
		case BUSQUEDA_ANCHURA:
			AgenteEjecutar.ejecutar(mapaAmbiente, mapaAgente,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_PROFUNDIDAD :
			AgenteEjecutar.ejecutar(mapaAmbiente, mapaAgente,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_COSTO_UNIFORME:
			AgenteEjecutar.ejecutar(mapaAmbiente, mapaAgente,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_AVARA:
			AgenteEjecutar.ejecutar(mapaAmbiente, mapaAgente,energía, post, dest, estrategia);
			break;
		}
	}
	
	
	public static void setSimulator(InterfazSimulator sim) {
		simulador = sim;
		try {
			String busqueda = "BÃºsqueda";
			switch (busquedaAct) {
			case (BUSQUEDA_ANCHURA):
				busqueda += " Anchura.";
				break;
			case (BUSQUEDA_PROFUNDIDAD):
				busqueda += " Profundidad.";
				break;
			case (BUSQUEDA_COSTO_UNIFORME):
				busqueda += " Costo Uniforme.";
				break;
			case (BUSQUEDA_AVARA):
				busqueda += " A*.";
				break;
			}
			
		window = new PanelSimulador();
		window.frame.setVisible(true);
	
		if(idIngreso=="ingreso1"){
			dibujarAgente(new Point(418,395), 0);
		}
		else{
			dibujarAgente(new Point(28,606), 0);
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		autoStep = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        autoStep();
		    }
		});
	}
	
	public static void avanzar() {
		int res = simulador.avanzar();
		if (res == 1) {
			autoStep.stop();
			window.terminar();
			simulador.terminar();
		}
	}
	
	public static void autoStep() {
		if (autoStep.isRunning())
			avanzar();
	}
	
	public static void registrarPosicion(String texto) {
		window.textField.setText(texto);

	}
	
	public static void registrarAccion(String texto) {
		window.textField_3.removeAll();
		window.textField_3.repaint();
		window.textField_3.setText(texto);

	}
	

	
	public static void registrarEnergia(String texto) {
		window.textField_1.setText(texto);
	}
	
	public static void registrarPosicionObjetivo(String texto) {
		window.textField_2.setText(texto);
	}
	
	public static void registrarPersepcion(String texto) {
		window.textPane_1.setText(texto);
	}
	
	public static void registrarHabitacionesVisitadas(String texto) {
//		window.textPane.setText("");
		window.textPane.setText(texto);
	}
	
	public static void registrarPosicionActual(String texto) {
		window.txtPosicionAgente.setText(texto);
	}
	
	public static void registrarPercepcion(String texto) {
		String str="";
		str+=window.textPane_1.getText();
		str+="\n";
		str+=texto;
		window.textPane_1.setText(str);
	}
	
	public static void registrarExito(String texto) {
		window.textField_4.setText(texto);
	}
	
	public static void dibujarAgente(Point posicion, int nivel) {
		window.dibujarAgente(posicion, nivel);
	}
}
