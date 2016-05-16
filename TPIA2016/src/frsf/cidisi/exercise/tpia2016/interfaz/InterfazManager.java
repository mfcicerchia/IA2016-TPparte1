package frsf.cidisi.exercise.tpia2016.interfaz;

import java.awt.EventQueue;
import frsf.cidisi.exercise.tpia2016.search.AgenteEjecutar;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.GoalBasedAgentSimulator;

public class InterfazManager {
	
	// Numeracion de los tipos de busqueda disponibles
	public static final int BUSQUEDA_ANCHURA 			= 0;
	public static final int BUSQUEDA_PROFUNDIDAD 		= 1;
	public static final int BUSQUEDA_COSTO_UNIFORME 	= 2;
	public static final int BUSQUEDA_AVARA				= 3;
	
	private static GoalBasedAgentSimulator simulador;
	private static PanelSimulador window;
	private static Timer autoStep;
	private static int escenarioAct;
	private static int busquedaAct;
	
	public static void comenzarSimulador(Edificio mapa, int energía, Habitacion post,Habitacion dest, int estrategia) {
		busquedaAct = estrategia;
		switch(busquedaAct){

		case BUSQUEDA_ANCHURA:
			AgenteEjecutar.ejecutar(mapa,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_PROFUNDIDAD :
			AgenteEjecutar.ejecutar(mapa,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_COSTO_UNIFORME:
			AgenteEjecutar.ejecutar(mapa,energía, post, dest, estrategia);
			break;

		case BUSQUEDA_AVARA:
			//ArqueologoEstrategia.ejecutar(escenario);
			break;
		}
	}
	
	public static void mostrarConfigurador() {
		window.cerrar();
		try {
			PanelConfigurar ventana = new PanelConfigurar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setSimulator(GoalBasedAgentSimulator sim) {
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
				busqueda += " A* busqueda.";
				break;
			}
			window = new PanelSimulador(escenarioAct, busqueda);
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
	
	public static void mostrarAgentes(int posArq, int posPir) {
		if (posArq>=11)
			posArq = 5;
		window.mapa.moverAgentes(posArq, posPir);
	}
	
	public static void registrarEvento(String texto) {
		window.logPanel.addEvent(texto);
	}
	
	public static void actualizarDatos(int dist, int botin, double cont) {
		window.actualizarDatos(dist, botin, cont);
	}
	
	public static void actualizarInventario(int[] botin) {
		window.actualizarInventario(botin);
	}
	
	public static void actualizarIsla(int[][] tesoros) {
		window.actualizarIsla(tesoros);
	}
	
	public static void setAutoStep(boolean activar) {
		if (activar)
			autoStep.start();
		else
			autoStep.stop();
	}
	
	public static void autoStep() {
		if (autoStep.isRunning())
			avanzar();
	}

}
