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

    public Agente(Edificio mapa, int energ�a, Habitacion post,Habitacion dest) {

        // The Agent Goal
        Objetivo agGoal = new Objetivo();
       

        // The Agent State
        EstadoAgente agState = new EstadoAgente(mapa, energ�a, post, dest);
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        // Operador IrPasillo
        for(Pasillo p: mapa.getPasillos()){operators.addElement(new IrPasillo(p.getIdHabitacion()));}
        
        // Operador IrAula
        for(Aula a: mapa.getAulas()){ operators.addElement(new IrAula(a.getIdHabitacion()));}
        
        // Operador IrEscalera
        for(Escalera e: mapa.getEscaleras()){operators.addElement(new IrEscalera(e.getIdHabitacion()));}
        
        // Operador IrAscensor
        for(Ascensor asc: mapa.getAscensores()){operators.addElement(new IrAscensor(asc.getIdHabitacion()));}
        
        // Operador IrFotocopiadora
        for(Fotocopiadora fotocopiadora: mapa.getFotocopiadoras()){operators.addElement(new IrFotocopiadora(fotocopiadora.getIdHabitacion()));}
        
        // Operador IrBa�o
        for(Ba�o ba�o: mapa.getBa�os()){operators.addElement(new IrBa�o(ba�o.getIdHabitacion()));}
        
        // Operador IrBiblioteca
        for(Biblioteca biblioteca: mapa.getBibliotecas()){operators.addElement(new IrBiblioteca(biblioteca.getIdHabitacion()));}
        
        // Operador IrCantina
		for (Cantina cantina: mapa.getCantinas()) {operators.addElement(new IrCantina(cantina.getIdHabitacion()));}
        
		// Operador Subir Nivel
		for (Ascensor asc : mapa.getAscensores()) {operators.addElement(new SubirNivel(asc.getIdHabitacion()));}
		for (Escalera esc : mapa.getEscaleras()) {operators.addElement(new SubirNivel(esc.getIdHabitacion()));}
		
		// Operador IrOficina
		for (Oficina oficina : mapa.getOficinas()) {operators.addElement(new IrOficina(oficina.getIdHabitacion()));}

		// Operador IrDepartamento
		for (Departamento depto : mapa.getDepartamentos()) {operators.addElement(new IrDepartamento(depto.getIdHabitacion()));}
		
		// Operador IrTaller
		for (Taller taller : mapa.getTalleres()) {operators.addElement(new IrTaller(taller.getIdHabitacion()));}
		
		// Operador IrIngreso
		for (Ingreso ingreso : mapa.getIngresos()) {operators.addElement(new IrIngreso(ingreso.getIdHabitacion()));}
		
		//Operador Bajar Nivel
        for(Habitacion h: mapa.getEscaleras()){operators.addElement(new BajarNivel(h.getIdHabitacion()));}
        for(Habitacion h: mapa.getAscensores()){operators.addElement(new BajarNivel(h.getIdHabitacion()));}
        
     // Operador IrLaboratorio
		for (Laboratorio lab : mapa.getLaboratorios()) {operators.addElement(new IrLaboratorio(lab.getIdHabitacion()));}
		
		
        	

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

    	// ANCHURA
        // Create the search strategy
    	 BreathFirstSearch strategy = new BreathFirstSearch(); //(esta estaba desde el idemia)
    	
    	// PROFUNDIDAD
    	// Estrategia de busqueda en profundidad
    	 // DepthFirstSearch strategy = new DepthFirstSearch();
    	
    	//COSTO UNIFORME
    	//UniformCostSearch strategy = new UniformCostSearch(new CostFunction());

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
