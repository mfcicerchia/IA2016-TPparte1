package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.search.actions.*;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

public class Agente extends SearchBasedAgent {

    public Agente(Edificio mapa, int energía, Habitacion post,Habitacion dest) {

        // The Agent Goal
        Objetivo agGoal = new Objetivo();
       

        // The Agent State
        EstadoAgente agState = new EstadoAgente(mapa, energía, post, dest);
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        
        for(Pasillo p: mapa.getPasillos()){
        	operators.addElement(new IrPasillo(p.getIdHabitacion()));
        }
        
        for(Aula a: mapa.getAulas()){
        	System.out.println(a.getClass().getSimpleName() +" - "+ a.getIdHabitacion()+" ");
        	IrAula irAula = new IrAula(a.getIdHabitacion());
            operators.addElement(irAula);
        }
        
        for(Escalera e: mapa.getEscaleras()){
        	operators.addElement(new IrEscalera(e.getIdHabitacion()));
        }
        
        for(Ascensor asc: mapa.getAscensores()){
        	operators.addElement(new IrAscensor(asc.getIdHabitacion()));
        }
        
        for(Fotocopiadora fotocopiadora: mapa.getFotocopiadoras()){
        	System.out.println(fotocopiadora.getClass().getSimpleName());
        	System.out.println(fotocopiadora.getDescripcion());
        	operators.addElement(new IrFotocopiadora(fotocopiadora.getIdHabitacion()));
        }
        
        for(Baño baño: mapa.getBaños()){
        	operators.addElement(new IrBaño(baño.getIdHabitacion()));	
        }
        
        for(Biblioteca biblioteca: mapa.getBibliotecas()){
        	 operators.addElement(new IrBiblioteca(biblioteca.getIdHabitacion()));
        }
        
		for (Cantina cantina: mapa.getCantinas()) {
			operators.addElement(new IrCantina(cantina.getIdHabitacion()));
		}
        
		// Para cada nodo ascensor y cada nodo escalera se crea un nuevo operador
		// el cual sera evaluado en las precondiciones del operador consultando
		// si dicho nodo es adyacente a la posicion actual
		for (Ascensor asc : mapa.getAscensores()) {
			operators.addElement(new SubirNivel(asc.getIdHabitacion()));
		}
		
		for (Escalera esc : mapa.getEscaleras()) {
			operators.addElement(new SubirNivel(esc.getIdHabitacion()));
		}
		
		for (Oficina oficina : mapa.getOficinas()) {
			operators.addElement(new IrOficina(oficina.getIdHabitacion()));
		}
              
		for (Departamento depto : mapa.getDepartamentos()) {
		System.out.println(depto.getClass().getSimpleName());
    	System.out.println(depto.getIdHabitacion());
			operators.addElement(new IrDepartamento(depto.getIdHabitacion()));	
		}
		
		
		/** Ir laboratorio esta teniendo problemas, quiza por el id**/
//		for (Laboratorio lab : mapa.getLaboratorios()) {
//			operators.addElement(new IrLaboratorio(lab.getIdHabitacion()));
//		}
		
		for (Taller taller : mapa.getTalleres()) {
			operators.addElement(new IrLaboratorio(taller.getIdHabitacion()));
		}
		
		for (Ingreso ingreso : mapa.getIngresos()) {
			operators.addElement(new IrLaboratorio(ingreso.getIdHabitacion()));
		}
	

//        	
//        for(Habitacion h: listaDeEscalerasYAscensores){
//        	operators.addElement(new BajarNivel(h.getIdHabitacion()));
//        }
//        
//        
		
		
        	

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
    	// BreathFirstSearch strategy = new BreathFirstSearch(); //(esta estaba desde el idemia)
    	
    	
//    	// Estrategia de busqueda en profundidad
    	DepthFirstSearch strategy = new DepthFirstSearch();

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
