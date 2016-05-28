package frsf.cidisi.exercise.tpia2016.search.actions;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrPasillo extends SearchAction {

	private String idPasillo;
	public IrPasillo(String idP) {
		this.idPasillo = idP;
	}

	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgente agState = (EstadoAgente) s;

		// TODO: LISTO - pensando
		
		// PREcondicion: 
		// * Si el agente tiene alguna habitacion adyacente del tipo Pasillo
		// * Si el agente tiene energia suficiente para moverse a la siguiente habitacion
		// POScondicion
		// * El agente cambia de posision a la habitacion del tipo Pasillo
		// * Decrementa su energia segun la distancia asociada en el enlace
		// * Retorna el estado actualizado
	
		

			Habitacion posicionActual = agState.getPosicion();
			int energiaDisponible = agState.getEnergía_agente();
			
			//obtengo la habitacion que cuyo id recibo como parametro
			Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idPasillo);
			
				if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h)&& 
					!(agState.getHabitaciones_visitadas().contains(h)) &&
					(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
					
					Pasillo pasillo = (Pasillo) h;
					if (!pasillo.isBloqueado()) {
						// 	decremento la energia
						agState.setEnergía_agente(energiaDisponible- agState.getMapa_ambiente().getCosto(agState.getPosicion(), pasillo));
						// me muevo a la siguiente habitacion
						agState.setPosicion(pasillo);
						// 	agrego la habitacion que visité
						agState.getHabitaciones_visitadas().add(pasillo);
						// retorno el estado actualizado
						return agState;
					}
			}
		return null;
	}

	/**
	 * This method updates the agent state and the real world state.
	 */
	@Override
	   public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoAgente agState = ((EstadoAgente) ast);

        // TODO: LISTO - real world!
        
 
		Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		boolean seMueve=false;
		
		//obtengo la habitacion que cuyo id recibo como parametro
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idPasillo);
		
			if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h)&& 
				!(agState.getHabitaciones_visitadas().contains(h)) &&
				(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
					
						// Update the agent state
						//decremento la energia en el mundo real
						agState.setEnergía_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
						// me muevo a la siguiente habitacion en el mundo real
						agState.setPosicion(h);
						// agrego la habitacion que visité 
						agState.getHabitaciones_visitadas().add(h);
						// aviso que puedo moverme en el mundo real para actualizar la posicion
						// del agente en el ambiente
						seMueve=true;
				}
			
	        
			// Si se puede mover informo el cambio de posicion en el ambiente.
	        if (seMueve) {
	            // Update the real world
	        	// actualizo la posicion del agente en el Ambiente
	        	environmentState.setPosicion_agente(agState.getPosicion());
	            return environmentState;
	        }
		
		
        return null;
    }

	/**
	 * This method returns the action cost.
	 */
	@Override
	public Double getCost() {
		return new Double(10);
	}

	/**
	 * This method is not important for a search based agent, but is essensial
	 * when creating a calculus based one.
	 */
	@Override
	public String toString() {
		return "IrPasillo" + idPasillo;
	}
}