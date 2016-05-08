package frsf.cidisi.exercise.tpia2016.search.actions;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrDepartamento extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoAgente agState = (EstadoAgente) s;
        
        // TODO: LISTO
      
    	// PREcondicion: 
		// * Si el agente tiene alguna habitacion adyacente del tipo DEPARTAMENTO
		// * Si el agente tiene energia suficiente para moverse
		// * Si la habitacion DEPARTAMENTO a la que se va a mover NO fue visitada
		// POScondicion
		// * El agente cambia de posicion, se mueve a la habitacion DEPARTAMENTO
		// * Decrementa su energia segun el costo de moverse a ese DEPARTAMENTO
		// * Retorna el estado actualizado
		
	
		Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
		

		for (Habitacion h : adyacentes) {
			if ((h.getClass().getSimpleName().equals("Departamento")) &&
			   !(agState.getHabitaciones_visitadas().contains(h)) &&
			   (energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
					//decremento la energia 
					agState.setEnergía_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
					// me muevo a la siguiente habitacion
					agState.setPosicion(h);
					// agrego la habitacion que visité
					agState.getHabitaciones_visitadas().add(h);
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

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        if (true) {
            // Update the real world
            
            // Update the agent state
            
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