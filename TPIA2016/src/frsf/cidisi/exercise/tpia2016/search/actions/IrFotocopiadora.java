package frsf.cidisi.exercise.tpia2016.search.actions;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrFotocopiadora extends SearchAction {
	
	
	
	String idFotocopiadora;
	public IrFotocopiadora(String idFotocopiadora){
		this.idFotocopiadora = idFotocopiadora;
	}

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoAgente agState = (EstadoAgente) s;
        
        // TODO: LISTO - pensando

        Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		
		//obtengo la habitacion que cuyo id recibo como parametro
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idFotocopiadora);
		
			if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h)&& 
				!(agState.getHabitaciones_visitadas().contains(h)) &&
				(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
							//decremento la energia 
							agState.setEnergía_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
							// me muevo a la siguiente habitacion
							agState.setPosicion(h);
							// agrego la habitacion que visité
							// agState.getHabitaciones_visitadas().add(h);
							// retorno el estado actualizado
							return agState;
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
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idFotocopiadora);
		
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
        return "IrFotocopiadora " + idFotocopiadora;
    }
}