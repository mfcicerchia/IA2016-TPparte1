package frsf.cidisi.exercise.tpia2016.search.actions;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrDepartamento extends SearchAction {
	
	
	
	String idDepartamento;
	public IrDepartamento(String idDepartamento){
		this.idDepartamento = idDepartamento;
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
		// * Si el agente tiene alguna habitacion adyacente del tipo AULA
		// * Si el agente tiene energia suficiente para moverse
		// * Si la habitacion Departamento a la que se va a mover NO fue visitada
		// POScondicion
		// * El agente cambia de posicion, se mueve a la habitacion AULA
		// * Decrementa su energia segun el costo de moverse a ese aula
		// * Retorna el estado actualizado
		
	
        Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		
		//obtengo la habitacion que cuyo id recibo como parametro
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idDepartamento);
		
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
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idDepartamento);
		
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
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "IrDepartamento";
    }
}