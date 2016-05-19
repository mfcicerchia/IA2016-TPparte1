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
    @Override
    public double calculateCost(NTree node) {
        
        //TODO: Complete Method
        //System.out.println("costo DE ejectura la Accion: " + node.getAction().getCost());
        //return node.getAction().getCost();
		NTree padre = node.getParent();

		int costoAcumulado = 0;
		int costoDelEnlace=0;
		EstadoAgente estadoPadre;
		EstadoAgente estadoActual = (EstadoAgente)node.getAgentState();;
		 
		
		

		if (padre == null) {
			return 0;
		}else{
			estadoPadre = (EstadoAgente) padre.getAgentState();
			// SI SUBO: el costo es el costo del enlace
			/// Si subo las escaleras el costo es el costo del enlace
			if(estadoActual.getClass().equals("Escalera")&& estadoPadre.getClass().equals("Escalera")&&  
			   estadoActual.getPosicion().getNivel() > estadoPadre.getPosicion().getNivel()){
				costoDelEnlace = estadoActual.getMapa_ambiente().getCosto(estadoActual.getPosicion(), estadoPadre.getPosicion());				
				costoAcumulado+= costoDelEnlace;
				
			}
			
			// SI BAJO: el costo es cinco veces el costo del enlace
			/// Si subo las escaleras el costo es el costo del enlace
			if(estadoActual.getClass().equals("Escalera")&& estadoPadre.getClass().equals("Escalera")&&  
			   estadoActual.getPosicion().getNivel() < estadoPadre.getPosicion().getNivel()){
				costoDelEnlace = estadoActual.getMapa_ambiente().getCosto(estadoActual.getPosicion(), estadoPadre.getPosicion());				
				costoAcumulado+= costoDelEnlace*5;
				
			}
			
			// Si es cualquier otro movimiento acumulo el costo/distancia
			// de la conexion
			costoDelEnlace = estadoActual.getMapa_ambiente().getCosto(estadoActual.getPosicion(), estadoPadre.getPosicion());
			costoAcumulado+=costoDelEnlace;
			
		}
		return costoAcumulado;
	}

	
	public String toString() {
		return super.toString();
	}
}
