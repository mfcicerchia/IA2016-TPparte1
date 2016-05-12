package frsf.cidisi.exercise.tpia2016.search.actions;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Ascensor;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrAscensor extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoAgente agState = (EstadoAgente) s;
        
        // TODO: LISTO - pensando
        
    	// PREcondicion: 
		// * Si el agente tiene alguna habitacion adyacente del tipo ASCENSOR
        // * Si el ascensor no tiene pitido
		// * Si el agente tiene energia suficiente para moverse
		// POScondicion
		// * El agente cambia de posicion, se mueve a la habitacion ASCENSOR
		// * Decrementa su energia segun el costo de moverse al ascensor
		// * Retorna el estado actualizado
		
	
		Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnerg�a_agente();
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
		

		for (Habitacion h : adyacentes) {
			if ((h.getClass().getSimpleName().equals("Ascensor")) &&
			   (energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual,h) > 0)){
				
				Ascensor ascensor = (Ascensor) h;
				if (ascensor.isPitido()) {
					return null;
				} else {
					//decremento la energia 
					agState.setEnerg�a_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
					// me muevo a la siguiente habitacion
					agState.setPosicion(h);
					// agrego la habitacion que visit�
					// agState.getHabitaciones_visitadas().add(h);
					// retorno el estado actualizado
					return agState;
				}
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

        // TODO: LISTO - real world
        
    	Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnerg�a_agente();
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
		boolean seMueve=false;

		for (Habitacion h : adyacentes) {
			if ((h.getClass().getSimpleName().equals("Ascensor")) &&
			   (energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual,h) > 0)){
				
				Ascensor ascensor = (Ascensor) h;
				if (ascensor.isPitido()) {
					return null;
				} else {
					//decremento la energia 
					agState.setEnerg�a_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
					// me muevo a la siguiente habitacion
					agState.setPosicion(h);
					// agrego la habitacion que visit�
					// agState.getHabitaciones_visitadas().add(h);
					seMueve=true;
				}
			}
		}
        
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
        return "IrAscensor";
    }
}