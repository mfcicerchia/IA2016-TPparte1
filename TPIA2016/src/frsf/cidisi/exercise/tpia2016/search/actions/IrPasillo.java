package frsf.cidisi.exercise.tpia2016.search.actions;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrPasillo extends SearchAction {

	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgente agState = (EstadoAgente) s;

		// TODO: LISTO
		
		// PREcondicion: 
		// * Si el agente tiene alguna habitacion adyacente del tipo Pasillo
		// * Si el agente tiene energia suficiente para moverse a la siguiente habitacion
		// POScondicion
		// * El agente cambia de posision a la habitacion del tipo Pasillo
		// * Decrementa su energia segun la distancia asociada en el enlace
		// * Retorna el estado actualizado
		
		
		Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());


		for (Habitacion h : adyacentes) {
			if ((h.getClass().getSimpleName().equals("Pasillo")) &&
			   (energiaDisponible - agState.getMapa_ambiente().getCosto(agState.getPosicion(), h) > 0)) {
				
				Pasillo pasillo = (Pasillo) h;
				if (pasillo.isBloqueado()) {
					break;
				} else {
					// decremento la energia
					agState.setEnergía_agente(energiaDisponible- agState.getMapa_ambiente().getCosto(agState.getPosicion(), pasillo));
					// me muevo a la siguiente habitacion
					agState.setPosicion(pasillo);
					// agrego la habitacion que visité
					agState.getHabitaciones_visitadas().add(pasillo);
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
		return "IrPasillo";
	}

}