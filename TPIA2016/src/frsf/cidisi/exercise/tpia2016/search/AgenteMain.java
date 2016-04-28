package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteMain {
	
	/**
     * @param args
     * @throws PrologConnectorException
     */
    public static void main(String[] args) throws PrologConnectorException {
        
//    	Edificio plano = CargarPlano();
//    	Principal ventana = new Principal(plano);
    	Agente agent = new Agente();
        Universidad environment = new Universidad();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        
       //punto donde inicializar la interfaz
        //System.
        simulator.start();
    }

}
