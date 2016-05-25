package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    
    public double calculateCost(NTree node) {
        
        //TODO: Complete Method
        //System.out.println("costo DE ejectura la Accion: " + node.getAction().getCost());
        //return node.getAction().getCost();
        
        
		NTree padre = node.getParent();
		EstadoAgente estadoPadre = (EstadoAgente) padre.getAgentState();
		EstadoAgente estadoActual = (EstadoAgente) node.getAgentState();
		
		int costoDelEnlace;
		Double costo;
    	
		// SI SUBO: el costo es el costo del enlace
		/// Si subo las escaleras el costo es el costo del enlace
		if (estadoActual.getClass().equals("Escalera") && estadoPadre.getClass().equals("Escalera")
				&& estadoActual.getPosicion().getNivel() > estadoPadre.getPosicion().getNivel()) {
			costoDelEnlace = estadoActual.getMapa_ambiente().getCosto(estadoActual.getPosicion(),
					estadoPadre.getPosicion());
			return costoDelEnlace;

			// SI BAJO: el costo es cinco veces el costo del enlace
			/// Si subo las escaleras el costo es el costo del enlace
		} else if (estadoActual.getClass().equals("Escalera") && estadoPadre.getClass().equals("Escalera")
				&& estadoActual.getPosicion().getNivel() < estadoPadre.getPosicion().getNivel()) {
			costoDelEnlace = estadoActual.getMapa_ambiente().getCosto(estadoActual.getPosicion(),
					estadoPadre.getPosicion());
			costo = (double) (costoDelEnlace * 5);
			return costo;

		} else {
			// Si es cualquier otro movimiento acumulo el costo/distancia
			// de la conexion
			costo = node.getAction().getCost();
			return node.getAction().getCost();
		}
	}
	

	
	public String toString() {
		return super.toString();
	}
}
