
package frsf.cidisi.exercise.tpia2016.search;




import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;

import frsf.cidisi.exercise.tpia2016.utilidades.CargarPlanos;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteMain {
	
	/**
     * @param args
	 * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
    	//Se cargan los planos del edificio en el atributo edificio
    	CargarPlanos mapaInformation = new CargarPlanos();
    	Edificio edificio = mapaInformation.getMapa();
    	//edificio.getHabitacionPorID("esc1");
    	
    	// Se crea la ventana principal y desde aca se da el OK 
    	// para que inicie la simulacion
    	
    	//Principal ventana = new Principal(edificio);
    	
    	
    	// Setear el estado del agente y del ambiente con los datos 
    	// ya cargados
    	
    	Agente agent = new Agente(edificio, 1000, edificio.getHabitacionPorID("au9") ,edificio.getHabitacionPorID("mecanica"));
        Universidad environment = new Universidad(edificio);

        
        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
        
        
        
       //posible punto donde inicializar la interfaz
        //System.out.println("Aprente \'intro\' para iniciar la simulacion");
        //System.in.read();
        simulator.start();
    }

}
