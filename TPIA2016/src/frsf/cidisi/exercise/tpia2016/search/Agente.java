package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.search.actions.IrAula;
import frsf.cidisi.exercise.tpia2016.search.actions.IrAscensor;
import frsf.cidisi.exercise.tpia2016.search.actions.IrBiblioteca;
import frsf.cidisi.exercise.tpia2016.search.actions.IrEscalera;
import frsf.cidisi.exercise.tpia2016.search.actions.IrDepartamento;
import frsf.cidisi.exercise.tpia2016.search.actions.IrBa�o;
import frsf.cidisi.exercise.tpia2016.search.actions.IrLaboratorio;
import frsf.cidisi.exercise.tpia2016.search.actions.IrPasillo;
import frsf.cidisi.exercise.tpia2016.search.actions.SubirNivel;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Aula;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Pasillo;
import frsf.cidisi.exercise.tpia2016.search.actions.BajarNivel;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
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
        
        for(Pasillo p: mapa.getPaillos()){
        	operators.addElement(new IrPasillo(p.getIdHabitacion()));
        }
        
        for(Aula a: mapa.getAulas()){
            operators.addElement(new IrAula(a.getIdHabitacion()));
        }
 	
        operators.addElement(new IrAscensor());
        
        for(Escalera e: mapa.getEscaleras()){
        	operators.addElement(new IrEscalera(e.getIdHabitacion()));
        }
        operators.addElement(new IrDepartamento());	
        
        operators.addElement(new IrBa�o());	
        
        
        
        	
        ArrayList<Habitacion> listaDeEscalerasYAscensores = new ArrayList<Habitacion>();
        listaDeEscalerasYAscensores.addAll(mapa.getEscaleras());
        listaDeEscalerasYAscensores.addAll(mapa.getEscaleras());
        
        for(Habitacion h: listaDeEscalerasYAscensores){
        	operators.addElement(new SubirNivel(h.getIdHabitacion()));
        }
        	
        for(Habitacion h: listaDeEscalerasYAscensores){
        	operators.addElement(new BajarNivel(h.getIdHabitacion()));
        }
        
        
        operators.addElement(new IrBiblioteca());
        operators.addElement(new IrLaboratorio());
        	

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
        BreathFirstSearch strategy = new BreathFirstSearch();          

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.XML_TREE);

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
