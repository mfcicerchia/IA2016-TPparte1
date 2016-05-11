package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class Objetivo extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {

		// TODO: LISTO...

		// La prueba de meta es si la posicion actual es igual a la posicion
		// objetivo Si la energia es mayor o igual a cero
		if (((EstadoAgente) agentState).getPosicionObjetivo().equals(((EstadoAgente) agentState).getPosicion())){
				return true;
		}
		else {
			return false;
		}

	}
}