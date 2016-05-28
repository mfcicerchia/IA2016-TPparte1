package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    public double getEstimatedCost(NTree node) {
    
    	// Obtengo el nodo padre del nodo actual y 
    	NTree padre =  node.getParent();
    	EstadoAgente estadoPadre;
    	
    	// obtengo el estado del nodo actual
    	EstadoAgente estadoActual = (EstadoAgente) node.getAgentState();
    	
    	//Costo Estimado (distancia Euclidea)
    	double distanciaEuclidea;
    	
    	// Obtengo el objetivo contra quien calculare la distancia euclidea
    	Habitacion objetivo = estadoActual.getDestino();
    	Habitacion miPosicion;
        
    	if (padre == null) {
			return 0;
		}else{
			// si este nodo no tiene padre, soy el padre (nodo inicial)
	    	if(padre.getParent()==null){
	    		estadoPadre = (EstadoAgente) padre.getAgentState();
	    		// mi posicion es la del estado padre por que soy el padre
	    		miPosicion = estadoPadre.getPosicion();
	    		
	    		/// La distancia se mide sobre la linea recta entre mi posicion y el objetivo
	    		double cuadX = Math.pow(Math.abs(objetivo.getPosicion().getX() - miPosicion.getPosicion().getX()),2);
	    		double cuadY = Math.pow(Math.abs(objetivo.getPosicion().getY() - miPosicion.getPosicion().getY()), 2);
	    		double cuadZ = Math.abs(Math.pow(objetivo.getNivel() - miPosicion.getNivel(), 2));
	    		double sum = cuadX + cuadY + cuadZ;
	    		distanciaEuclidea = Math.sqrt(sum);
	    	}
	    	else{
	    		// si no soy el padre mi posicion es la de mi estado actual
	    		miPosicion = estadoActual.getPosicion();
	    		
	    		double cuadX = Math.pow(Math.abs(objetivo.getPosicion().getX() - miPosicion.getPosicion().getX()),2);
	    		double cuadY = Math.pow(Math.abs(objetivo.getPosicion().getY() - miPosicion.getPosicion().getY()), 2);
	    		double cuadZ = Math.abs(Math.pow(objetivo.getNivel() - miPosicion.getNivel(), 2));
	    		double sum = cuadX + cuadY + cuadZ;
	    		distanciaEuclidea = Math.sqrt(sum);
	    	}
        return distanciaEuclidea;
    }
}
}