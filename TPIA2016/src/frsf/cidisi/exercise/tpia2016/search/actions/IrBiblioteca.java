package frsf.cidisi.exercise.tpia2016.search.actions;


import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrBiblioteca extends SearchAction  {
	
	String idBiblioteca;
	public IrBiblioteca (String idBiblioteca){
		this.idBiblioteca = idBiblioteca;
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
			// * Si el agente tiene alguna habitacion adyacente del tipo BIBLIOTECA		
			// * Si el agente tiene energia suficiente para moverse
			// * Si la habitacion BIBLIOTECA a la que se va a mover NO fue visitada
			// POScondicion
			// * El agente cambia de posicion, se mueve a la habitacion BIBLIOTECA
			// * Decrementa su energia segun el costo de moverse a ese BIBLIOTECA
			// * Retorna el estado actualizado
			
		
	        Habitacion posicionActual = agState.getPosicion();
			int energiaDisponible = agState.getEnerg�a_agente();
			
			//obtengo la habitacion que cuyo id recibo como parametro
			Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idBiblioteca);
			
				if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h)&& 
					!(agState.getHabitaciones_visitadas().contains(h)) &&
					(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
						//decremento la energia 
						agState.setEnerg�a_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
						// me muevo a la siguiente habitacion
						agState.setPosicion(h);
						// agrego la habitacion que visit�
						agState.getHabitaciones_visitadas().add(h);
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
			int energiaDisponible = agState.getEnerg�a_agente();
			
			//obtengo la habitacion que cuyo id recibo como parametro
			Habitacion h = agState.getMapa_ambiente().getHabitacionPorID(idBiblioteca);
			boolean seMueve = false;
			
				if (agState.getMapa_ambiente().isAdyacente(agState.getPosicion(), h)&& 
					!(agState.getHabitaciones_visitadas().contains(h)) &&
					(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h) > 0)){
						//decremento la energia 
						agState.setEnerg�a_agente(energiaDisponible-agState.getMapa_ambiente().getCosto(posicionActual, h));
						// me muevo a la siguiente habitacion
						agState.setPosicion(h);
						// agrego la habitacion que visit�
						agState.getHabitaciones_visitadas().add(h);
						
						seMueve = true;
				}
			
	    
	        
	        if (seMueve) {
	        	environmentState.setPosicion_agente(agState.getPosicion());
	            return environmentState;
	        }
	        else{
	        	return null;	
	        }
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
	        return "IrBiblioteca";
	    }
	
}
