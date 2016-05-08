package frsf.cidisi.exercise.tpia2016.search.actions;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Pasillo;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class BajarNivel extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoAgente agState = (EstadoAgente) s;
                
		// TODO: LISTO
		// PREcondicion: 
		// * Si el agente tiene alguna habitacion adyacente del tipo Escalera 
        // 		* Si esa habitacion escalera se encuentra en un nivel INFERIOR al actual
		// 		* Si el agente tiene energia suficiente para bajar el nivel
        //
        // * Si el agente tiene alguna habitacion adyacente del tipo Ascensor
        //		* Si ese nodo Ascensor esta en un nivel inferior
        // 		* Si ese nodo ascensor NO tiene activado el bip
        //		* Si el agente tiene energia para moverse para bajar X niveles (o podriamos considerar que no tiene costo
        //			ya que el agente no gasta energia mientras baja el/los niveles por el ascensor)
        		/** 
        		 Aca podriamos preguntar si hay energia electrica en el edificio 
        		 para que sea precondicion de ir en el ascentor. En ese caso estaria bien la 
        		 percepcion de energia del ambiente, seria un atributo mas del Edificio en ese caso
        		**/
		// POScondicion
        // * De moverse por la ESCALERA
		// 		* El agente cambia de posicion, se mueve un nivel hacia abajo en la misma escalera
		// 		* Decrementa su energia segun el costo de bajar ese nivel
		// 		* Retorna el estado actualizado
        // * De moverse por el ASCENSOR
        // 		* El agente cambia de posicion, se mueve por el ascensor a un nodo de nivel inferior
        //		* Decrementa su energia segun el costo de bajar el/los nivels
        //		* Retorna el estado actualizado
		
		
        Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		ArrayList<Habitacion> adyacentes = agState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
		
		if(posicionActual.getClass().getSimpleName().equals("Escalera")){
			bajarPorEscalera(posicionActual, adyacentes, energiaDisponible, agState);
		}
		if(posicionActual.getClass().getSimpleName().equals("Ascensor")){
			bajarPorAscensor(posicionActual, adyacentes, energiaDisponible, agState);
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
        return "BajarNivel";
    }
    
    
    
    /**
     * @param posicionActual
     * @param adyacentes
     * @param energiaDisponible
     * @param agState
     * @return: agState si actualiza el estado
     * 			null: si no se puede expandir
     */
    private EstadoAgente bajarPorAscensor(Habitacion posicionActual, ArrayList<Habitacion> adyacentes, int energiaDisponible, EstadoAgente agState){
    	for (Habitacion h : adyacentes) {
			if ((h.getNivel()<agState.getPosicion().getNivel()) &&
			   (energiaDisponible-agState.getMapa_ambiente().getCosto(agState.getPosicion(), h) > 0)){
					//decremento la energia 
					agState.setEnergía_agente(energiaDisponible- agState.getMapa_ambiente().getCosto(agState.getPosicion(), h));
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
     * @param posicionActual
     * @param adyacentes
     * @param energiaDisponible
     * @param agState
     * @return agState si actualiza el estado
     * 			null: si no se puede expandir
     */
    private EstadoAgente bajarPorEscalera(Habitacion posicionActual, ArrayList<Habitacion> adyacentes, int energiaDisponible, EstadoAgente agState){
    	
		for (Habitacion h : adyacentes) {
			if ((h.getNivel()<agState.getPosicion().getNivel()) &&
			   (energiaDisponible-agState.getMapa_ambiente().getCosto(agState.getPosicion(), h) > 0)){
				Escalera escalera = (Escalera) h;
				if (escalera.isBloqueada()) {
					break;
				} else {
					//decremento la energia 
					agState.setEnergía_agente(energiaDisponible- agState.getMapa_ambiente().getCosto(agState.getPosicion(), h));
					// me muevo a la siguiente habitacion
					agState.setPosicion(h);
					// agrego la habitacion que visité
					agState.getHabitaciones_visitadas().add(h);
					// retorno el estado actualizado
					return agState;
				}
			}
		}
		return null;
    }
    
}