package frsf.cidisi.exercise.tpia2016.search.actions;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;

import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class SubirNivel extends SearchAction {

	
	// id de la siguiente habitacion a la que se moverá
    String idHabitacionSgte;
    
	/**
	 * @param idHabitacion: id de la habitacion que recibe como parametro el constructor
	 *	puede ser:
	 *  	- un id de Escalera
	 * 		- un id de Ascensor
	 * */
	public SubirNivel(String idHabitacion){
		this.idHabitacionSgte = idHabitacion;
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
		// * Si el agente tiene alguna habitacion adyacente del tipo ESCALERA
        // 		* Si esa habitacion escalera se encuentra en un nivel SUPERIOR al actual
		// 		* Si el agente tiene energia suficiente bajar el nivel
		// 		* Si la habitacion Escalera a la que se va a mover NO fue visitada
        
        // * Si el agente tiene alguna habitacion adyacente del tipo ASCENSOR
        //		* Si ese nodo Ascensor esta en un nivel superior
        //		* Si el agente tiene energia para moverse para subir X niveles (o podriamos considerar que no tiene costo
        //			ya que el agente no gasta energia mientras baja el/los niveles por el ascensor)
		// POScondicion
        // * De moverse por la escalera
		// 		* El agente cambia de posicion, se mueve un nivel hacia ARRIBA en la misma escalera
		// 		* Decrementa su energia segun el costo de SUBIR ese nivel
		// 		* Retorna el estado actualizado
        // * De moverse por el ascensor
        // 		* El agente cambia de posicion, se mueve por el ascensor a un nodo de nivel superior
        //		* Decrementa su energia segun el costo de SUBIR el/los nivels
        //		* Retorna el estado actualizado
		
		
        Habitacion posicionActual = agState.getPosicion();
		int energiaDisponible = agState.getEnergía_agente();
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(this.idHabitacionSgte);
        
        

						
		if(posicionActual.getClass().getSimpleName().equals("Escalera")){
			
			if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h) &&
			   //!(esc.isBloqueada())&&
			   (posicionActual.getNivel()<h.getNivel())&&
			   (energiaDisponible - agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)) {
				Escalera esc = (Escalera) h;
				if(!esc.isBloqueada()){
					// decremento la energia
					agState.setEnergía_agente(energiaDisponible - agState.getMapa_ambiente().getCosto(agState.getPosicion(), h));
					// me muevo a la siguiente habitacion
					agState.setPosicion(h);
					// agrego la habitacion que visité
					// agState.getHabitaciones_visitadas().add(h);
					// retorno el estado actualizado
					return agState;
				}
			}
			return null;
		}
			
		
		
		if(posicionActual.getClass().getSimpleName().equals("Ascensor")){
						if (agState.getMapa_ambiente().isAdyacente(posicionActual, h) &&
					   (posicionActual.getNivel()<h.getNivel())&&
					   (energiaDisponible - agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)) {
							// decremento la energia
							agState.setEnergía_agente(energiaDisponible - agState.getMapa_ambiente().getCosto(agState.getPosicion(), h));
							// me muevo a la siguiente habitacion
							agState.setPosicion(h);
							// agrego la habitacion que visité
							// agState.getHabitaciones_visitadas().add(h);
							// retorno el estado actualizado
							return agState;

						}
				    	return null;
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
		int energiaDisponible = agState.getEnergía_agente();
		Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(this.idHabitacionSgte);
        boolean seMueve = false;

						
			if(posicionActual.getClass().getSimpleName().equals("Escalera")){
				
				if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h) &&
					//!(esc.isBloqueada())&&
				   (posicionActual.getNivel()<h.getNivel())&&
				   (energiaDisponible - agState.getMapa_ambiente().getCosto(posicionActual,h) > 0)) {
					Escalera esc = (Escalera) h;
						if(!esc.isBloqueada()){
							// decremento la energia
							agState.setEnergía_agente(energiaDisponible - agState.getMapa_ambiente().getCosto(agState.getPosicion(), esc));
							// me muevo a la siguiente habitacion
							agState.setPosicion(esc);
							// agrego la habitacion que visité
							 agState.getHabitaciones_visitadas().add(esc);
							// retorno el estado actualizado
							seMueve = true;
						}
					}
			}
		
		if(posicionActual.getClass().getSimpleName().equals("Ascensor")){
			if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h) &&
					   (posicionActual.getNivel()<h.getNivel())&&
					   (energiaDisponible - agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)) {
						// decremento la energia
						agState.setEnergía_agente(energiaDisponible - agState.getMapa_ambiente().getCosto(agState.getPosicion(), h));
						// me muevo a la siguiente habitacion
						agState.setPosicion(h);
						// agrego la habitacion que visité
						 agState.getHabitaciones_visitadas().add(h);
						// retorno el estado actualizado
						seMueve = true;
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
        return new Double(10);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "SubirNivel";
    }
}