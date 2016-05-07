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

		// TODO: Use this conditions
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente()
				.getHabitacionesAdyacentes(
						agState.getPosicion().getIdHabitacion());

		// PreConditions:
		for (Habitacion h : adyacentes) {
			if ((h.getClass().getSimpleName().equals("Pasillo"))
					&& !(agState.getHabitaciones_visitadas().contains(h))
					&& (agState.getEnergía_agente()
							- agState.getMapa_ambiente().getCosto(
									agState.getPosicion(), h) > 0)) {

				Pasillo pas = (Pasillo) h;
				if (pas.isBloqueado()) {
					break;
				} else {

					// PostConditions:
					agState.setPosicion(h);
					agState.setEnergía_agente(agState.getEnergía_agente()
							- agState.getMapa_ambiente().getCosto(
									agState.getPosicion(), h));
					agState.getHabitaciones_visitadas().add(h);

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