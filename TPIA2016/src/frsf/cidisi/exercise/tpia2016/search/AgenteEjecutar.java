package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.interfaz.InterfazSimulator;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class AgenteEjecutar {
	/**
	 * @param mapaAgente
	 * @param args
	 * @throws Exception
	 */
	
    public static void ejecutar(Edificio mapa, Edificio mapaAgente, int energ�a, Habitacion post,Habitacion dest, int busqueda) {
    	
    	Agente agent = new Agente(mapaAgente, energ�a, post ,dest);
    	Universidad environment = new Universidad(mapa);
    	
    	InterfazSimulator simulator = new InterfazSimulator(environment, agent);       
        simulator.start(busqueda);
    }

}