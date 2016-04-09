

package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAgente extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	// TODO: Complete Method
        if  (true) //(destino.tipo==habitacion.tipo && destino.numero == habitacion.numero  )
        	{
            return true;
        	}
        return false;
	}
}