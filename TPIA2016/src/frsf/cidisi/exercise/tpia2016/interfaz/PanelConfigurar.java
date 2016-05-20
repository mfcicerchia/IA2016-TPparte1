package frsf.cidisi.exercise.tpia2016.interfaz;


import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.exercise.tpia2016.search.AgenteEjecutar;
import frsf.cidisi.exercise.tpia2016.utilidades.*;
import frsf.cidisi.exercise.tpia2016.interfaz.InterfazManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class PanelConfigurar {

	PanelSimulador window;
	private Edificio edificio;
	private Edificio edificio_2;
	private JFrame frame;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextPane lblEnergiaInicialtext;
	private JCheckBox chckbxBeepAscensor;
	private JCheckBox chckbxPasillo_1_0;
	private JCheckBox chckbxPasillo_2_0;
	private JCheckBox chckbxPasillo_3_0;
	private JCheckBox chckbxPasillo_4_0;
	private JCheckBox chckbxPasillo_5_0;
	private JCheckBox chckbxPasillo_6_0;
	private JCheckBox chckbxPasillo_1_1;
	private JCheckBox chckbxPasillo_2_1;
	private JCheckBox chckbxPasillo_3_1;
	private JCheckBox chckbxPasillo_4_1;
	private JCheckBox chckbxPasillo_5_1;
	private JCheckBox chckbxPasillo_6_1;
	private JCheckBox chckbxPasillo_1_2;
	private JCheckBox chckbxPasillo_2_2;
	private JCheckBox chckbxPasillo_1_3;
	private JCheckBox chckbxPasillo_2_3;
	private JComboBox comboBox;
	private JLabel lblBloqueosEscaleras;
	private JLabel lblPlantaBaja_1;
	private JCheckBox chckbxEscalera_1_0;
	private JCheckBox chckbxEscalera_2_0;
	private JCheckBox chckbxEscalera_3_0;
	private JCheckBox chckbxEscalera_4_0;
	private JCheckBox chckbxEscalera_5_0;
	private JCheckBox chckbxEscalera_6_0;
	private JCheckBox chckbxEscalera_7_0;
	private JLabel lblPrimerPiso_1;
	private JCheckBox chckbxEscalera_1_1;
	private JCheckBox chckbxEscalera_2_1;
	private JCheckBox chckbxEscalera_3_1;
	private JCheckBox chckbxEscalera_4_1;
	private JCheckBox chckbxEscalera_5_1;
	private JCheckBox chckbxEscalera_6_1;
	private JCheckBox chckbxEscalera_7_1;
	private JLabel lblSegundoPiso_1;
	private JCheckBox chckbxEscalera_3_2;
	private JCheckBox chckbxEscalera_5_2;
	private JCheckBox chckbxEscalera_6_2;
	private JCheckBox chckbxEscalera_8_2;
	private JLabel lblTercerPiso_1;
	private JCheckBox chckbxEscalera_8_3;
	private JCheckBox chckbxEscalera_3_3;
	ArrayList<JCheckBox> cheks=new ArrayList<JCheckBox>();
	ArrayList<JCheckBox> chekss=new ArrayList<JCheckBox>();


	
	/**
	 * Create the application.
	 */
	public PanelConfigurar() {
		try {
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		
		CargarPlanos mapaInformation = new CargarPlanos();
		edificio = mapaInformation.getMapa();
		edificio_2= mapaInformation.getMapa();
		Vector<String> habitaciones = new Vector<String>();

		
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TP INTELIGENCIA ARTIFICIAL - CONFIGURAR ESCENARIO");
		frame.getContentPane().setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill]", "[grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][]"));
		frame.getContentPane().add(panel_1, "cell 0 0,grow");
		
		JLabel lblEstadoInicial = new JLabel("ESTADO INICIAL AGENTE");
		lblEstadoInicial.setHorizontalAlignment(SwingConstants.CENTER);

		panel_1.add(lblEstadoInicial, "cell 0 0");

		
		JLabel label_2 = new JLabel("POSICIÓN INICIAL:");
		panel_1.add(label_2, "cell 0 1");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"INGRESO HALL", "INGRESO TORRE"}));
		panel_1.add(comboBox, "cell 0 2,growx");
		
		JLabel label_3 = new JLabel("ENERGÍA INICIAL:");
		panel_1.add(label_3, "cell 0 3");
		
		lblEnergiaInicialtext = new JTextPane();
		lblEnergiaInicialtext.setText("1000");
		panel_1.add(lblEnergiaInicialtext, "cell 0 4");
		
		JLabel lblEstratgia = new JLabel("ESTRAT\u00C9GIA");
		panel_1.add(lblEstratgia, "cell 0 5");
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"RECORRIDO EN ANCHURA", "RECORRIDO EN PROFUNDIDAD", "RECORRIDO COSTO UNIFORME", "BUSQUEDA AVARA*"}));
		panel_1.add(comboBox_1, "cell 0 6");
		
		JLabel lblObjetivoInicial = new JLabel("OBJETIVO INICIAL");
		panel_1.add(lblObjetivoInicial, "cell 0 7");
		
		comboBox_2 = new JComboBox();
		for(Habitacion h: edificio.getListaHabitaciones()){
			habitaciones.add(h.getDescripcion());
		}
		comboBox_2.setModel(new DefaultComboBoxModel(habitaciones));
		panel_1.add(comboBox_2 , "cell 0 8");
		
		chckbxBeepAscensor = new JCheckBox("BEEP ASCENSOR");
		panel_1.add(chckbxBeepAscensor , "cell 0 9");
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		panel_1.add(btnLimpiar, "cell 0 10");
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][][][][]"));
		frame.getContentPane().add(panel_2, "cell 1 0,grow");
		
		JLabel lblPasillosBloqueadas = new JLabel("PASILLOS BLOQUEADOS");
		lblPasillosBloqueadas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblPasillosBloqueadas, "cell 0 0");

		JLabel lblPlantaBaja = new JLabel("PLANTA BAJA:");
		panel_2.add(lblPlantaBaja, "cell 0 1");
		
		chckbxPasillo_1_0 = new JCheckBox("PASILLO 1");
		chckbxPasillo_1_0.setName("chckbxPasillo_1_0");
		panel_2.add(chckbxPasillo_1_0, "flowx,cell 0 2");
		cheks.add(chckbxPasillo_1_0);
		chckbxPasillo_2_0 = new JCheckBox("PASILLO 2");
		chckbxPasillo_2_0.setName("chckbxPasillo_2_0");
		panel_2.add(chckbxPasillo_2_0, "cell 0 2");
		cheks.add(chckbxPasillo_2_0);
		chckbxPasillo_3_0 = new JCheckBox("PASILLO 3");
		chckbxPasillo_3_0.setName("chckbxPasillo_3_0");
		panel_2.add(chckbxPasillo_3_0, "cell 0 2");
		cheks.add(chckbxPasillo_3_0);
		chckbxPasillo_4_0 = new JCheckBox("PASILLO 4");
		chckbxPasillo_4_0.setName("chckbxPasillo_4_0");
		panel_2.add(chckbxPasillo_4_0, "flowx,cell 0 3");
		cheks.add(chckbxPasillo_4_0);
		chckbxPasillo_5_0 = new JCheckBox("PASILLO 5");
		chckbxPasillo_5_0.setName("chckbxPasillo_5_0");
		panel_2.add(chckbxPasillo_5_0, "cell 0 3");
		cheks.add(chckbxPasillo_5_0);
		chckbxPasillo_6_0 = new JCheckBox("PASILLO 6");
		chckbxPasillo_6_0.setName("chckbxPasillo_6_0");
		panel_2.add(chckbxPasillo_6_0, "cell 0 3");
		cheks.add(chckbxPasillo_6_0);
		
		JLabel lblPrimerPiso = new JLabel("PRIMER PISO:");
		panel_2.add(lblPrimerPiso, "cell 0 4");
		
		chckbxPasillo_1_1 = new JCheckBox("PASILLO 1");
		chckbxPasillo_1_1.setName("chckbxPasillo_1_1");
		panel_2.add(chckbxPasillo_1_1, "flowx,cell 0 5");
		cheks.add(chckbxPasillo_1_1);
		
		chckbxPasillo_2_1 = new JCheckBox("PASILLO 2");
		chckbxPasillo_2_1.setName("chckbxPasillo_2_1");
		panel_2.add(chckbxPasillo_2_1, "cell 0 5");
		cheks.add(chckbxPasillo_2_1);
		
		chckbxPasillo_3_1 = new JCheckBox("PASILLO 3");
		chckbxPasillo_3_1.setName("chckbxPasillo_3_1");
		panel_2.add(chckbxPasillo_3_1, "cell 0 5");
		cheks.add(chckbxPasillo_3_1);
		
		chckbxPasillo_4_1 = new JCheckBox("PASILLO 4");
		chckbxPasillo_4_1.setName("chckbxPasillo_4_1");
		cheks.add(chckbxPasillo_4_1);
		panel_2.add(chckbxPasillo_4_1, "flowx,cell 0 6");
		cheks.add(chckbxPasillo_4_1);
		
		chckbxPasillo_5_1 = new JCheckBox("PASILLO 5");
		chckbxPasillo_5_1.setName("chckbxPasillo_5_1");
		panel_2.add(chckbxPasillo_5_1, "cell 0 6");
		cheks.add(chckbxPasillo_5_1);
		
		chckbxPasillo_6_1 = new JCheckBox("PASILLO 6");
		chckbxPasillo_6_1.setName("chckbxPasillo_6_1");
		panel_2.add(chckbxPasillo_6_1, "cell 0 6");
		cheks.add(chckbxPasillo_6_1);
		
		JLabel lblSegundoPiso = new JLabel("SEGUNDO PISO:");
		panel_2.add(lblSegundoPiso, "cell 0 7");
		
		chckbxPasillo_1_2 = new JCheckBox("PASILLO 1");
		chckbxPasillo_1_2.setName("chckbxPasillo_1_2");
		panel_2.add(chckbxPasillo_1_2, "flowx,cell 0 8");
		cheks.add(chckbxPasillo_1_2);
		
		chckbxPasillo_2_2 = new JCheckBox("PASILLO 2");
		chckbxPasillo_2_2.setName("chckbxPasillo_2_2");
		panel_2.add(chckbxPasillo_2_2, "cell 0 8");
		cheks.add(chckbxPasillo_2_2);
		
		JLabel lblTercerPiso = new JLabel("TERCER PISO");
		panel_2.add(lblTercerPiso, "cell 0 9");
		chckbxPasillo_1_3 = new JCheckBox("PASILLO 1");
		chckbxPasillo_1_3.setName("chckbxPasillo_1_3");
		panel_2.add(chckbxPasillo_1_3, "flowx,cell 0 10");
		cheks.add(chckbxPasillo_1_3);
		
		chckbxPasillo_2_3 = new JCheckBox("PASILLO 2");
		chckbxPasillo_2_3.setName("chckbxPasillo_2_3");
		panel_2.add(chckbxPasillo_2_3, "cell 0 10");
		cheks.add(chckbxPasillo_2_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][][][][][][]"));
		frame.getContentPane().add(panel_3, "cell 2 0,grow");
		
		lblBloqueosEscaleras = new JLabel("BLOQUEOS ESCALERAS");
		lblBloqueosEscaleras.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblBloqueosEscaleras, "cell 0 0");
		
		lblPlantaBaja_1 = new JLabel("PLANTA BAJA:");
		panel_3.add(lblPlantaBaja_1, "cell 0 1");
		
		chckbxEscalera_1_0 = new JCheckBox("ESCALERA 1");
		chckbxEscalera_1_0.setName("chckbxEscalera_1_0 ");
		panel_3.add(chckbxEscalera_1_0, "flowx,cell 0 2");
		chekss.add(chckbxEscalera_1_0);
		chckbxEscalera_2_0 = new JCheckBox("ESCALERA 2");
		chckbxEscalera_2_0.setName("chckbxEscalera_2_0 ");
		panel_3.add(chckbxEscalera_2_0, "cell 0 2");
		chekss.add(chckbxEscalera_2_0);
		chckbxEscalera_3_0 = new JCheckBox("ESCALERA 3");
		chckbxEscalera_3_0.setName("chckbxEscalera_3_0 ");
		panel_3.add(chckbxEscalera_3_0, "cell 0 2");
		chekss.add(chckbxEscalera_3_0);
		chckbxEscalera_4_0 = new JCheckBox("ESCALERA 4");
		chckbxEscalera_4_0.setName("chckbxEscalera_4_0 ");
		panel_3.add(chckbxEscalera_4_0, "flowx,cell 0 3");
		chekss.add(chckbxEscalera_4_0);
		chckbxEscalera_5_0 = new JCheckBox("ESCALERA 5");
		chckbxEscalera_5_0.setName("chckbxEscalera_5_0 ");
		panel_3.add(chckbxEscalera_5_0, "cell 0 3");
		chekss.add(chckbxEscalera_5_0);
		chckbxEscalera_6_0 = new JCheckBox("ESCALERA 6");
		chckbxEscalera_6_0.setName("chckbxEscalera_6_0 ");
		panel_3.add(chckbxEscalera_6_0, "cell 0 3");
		chekss.add(chckbxEscalera_6_0);
		chckbxEscalera_7_0 = new JCheckBox("ESCALERA 7");
		chckbxEscalera_7_0.setName("chckbxEscalera_7_0 ");
		panel_3.add(chckbxEscalera_7_0, "cell 0 4");
		chekss.add(chckbxEscalera_7_0);
		
		lblPrimerPiso_1 = new JLabel("PRIMER PISO:");
		panel_3.add(lblPrimerPiso_1, "cell 0 5");
		
		chckbxEscalera_1_1 = new JCheckBox("ESCALERA 1");
		chckbxEscalera_1_1.setName("chckbxEscalera_1_1");
		panel_3.add(chckbxEscalera_1_1, "flowx,cell 0 6");
		chekss.add(chckbxEscalera_1_1);
		chckbxEscalera_2_1 = new JCheckBox("ESCALERA 2");
		chckbxEscalera_2_1.setName("chckbxEscalera_2_1");
		panel_3.add(chckbxEscalera_2_1, "cell 0 6");
		chekss.add(chckbxEscalera_2_1);
		chckbxEscalera_3_1 = new JCheckBox("ESCALERA 3");
		chckbxEscalera_3_1.setName("chckbxEscalera_3_1");
		panel_3.add(chckbxEscalera_3_1, "cell 0 6");
		chekss.add(chckbxEscalera_3_1);
		chckbxEscalera_4_1 = new JCheckBox("ESCALERA 4");
		chckbxEscalera_4_1.setName("chckbxEscalera_4_1");
		panel_3.add(chckbxEscalera_4_1, "flowx,cell 0 7");
		chekss.add(chckbxEscalera_4_1);
		chckbxEscalera_5_1 = new JCheckBox("ESCALERA 5");
		chckbxEscalera_5_1.setName("chckbxEscalera_5_1");
		panel_3.add(chckbxEscalera_5_1, "cell 0 7");
		chekss.add(chckbxEscalera_5_1);
		chckbxEscalera_6_1 = new JCheckBox("ESCLAERA 6");
		chckbxEscalera_6_1.setName("chckbxEscalera_6_1");
		panel_3.add(chckbxEscalera_6_1, "cell 0 7");
		chekss.add(chckbxEscalera_6_1);
		chckbxEscalera_7_1 = new JCheckBox("ESCALERA 7");
		chckbxEscalera_7_1.setName("chckbxEscalera_7_1");
		panel_3.add(chckbxEscalera_7_1, "cell 0 8");
		chekss.add(chckbxEscalera_7_1);
		
		lblSegundoPiso_1 = new JLabel("SEGUNDO PISO:");
		panel_3.add(lblSegundoPiso_1, "cell 0 9");
		
		chckbxEscalera_3_2 = new JCheckBox("ESCALERA 3");
		chckbxEscalera_3_2.setName("chckbxEscalera_3_2");
		panel_3.add(chckbxEscalera_3_2, "cell 0 11");
		chekss.add(chckbxEscalera_3_2);
		chckbxEscalera_5_2 = new JCheckBox("ESCALERA 5");
		chckbxEscalera_5_2.setName("chckbxEscalera_5_2");
		panel_3.add(chckbxEscalera_5_2, "flowx,cell 0 10");
		chekss.add(chckbxEscalera_5_2);
		chckbxEscalera_6_2 = new JCheckBox("ESCALERA 6");
		chckbxEscalera_6_2.setName("chckbxEscalera_6_2");
		panel_3.add(chckbxEscalera_6_2, "cell 0 10");
		chekss.add(chckbxEscalera_6_2);
		chckbxEscalera_8_2 = new JCheckBox("ESCALERA 8");
		chckbxEscalera_8_2.setName("chckbxEscalera_8_2");
		panel_3.add(chckbxEscalera_8_2, "cell 0 10");
		chekss.add(chckbxEscalera_8_2);

		
		lblTercerPiso_1 = new JLabel("TERCER PISO:");
		panel_3.add(lblTercerPiso_1, "cell 0 12");
		
		chckbxEscalera_3_3 = new JCheckBox("ESCALERA 3");
		chckbxEscalera_3_3.setName("chckbxEscalera_3_3");
		panel_3.add(chckbxEscalera_3_3, "cell 0 13");
		chekss.add(chckbxEscalera_3_3);
		chckbxEscalera_8_3 = new JCheckBox("ESCALERA 8");
		chckbxEscalera_8_3.setName("chckbxEscalera_8_3");
		panel_3.add(chckbxEscalera_8_3, "flowx,cell 0 13");
		chekss.add(chckbxEscalera_8_3);


		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int estrategia = comboBox_1.getSelectedIndex();
				for(JCheckBox j: cheks){
					System.out.println("ffffffffffffffffffff"+j.getName()+"ffffffffffffffffffffff");
					if(j.isSelected()){
						String str=j.getName();
						Pasillo h;

						if(str=="chckbxPasillo_1_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p1-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_2_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p2-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_3_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p3-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_4_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p4-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_5_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p5-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_6_0"){
							h = (Pasillo) edificio.getHabitacionPorID("p6-0");
							h.setBloqueado(true);
						}
						else if(str=="chckbxPasillo_1_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p1-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_2_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p2-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_3_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p3-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_4_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p4-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_5_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p5-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_6_1"){
							h = (Pasillo) edificio.getHabitacionPorID("p6-1");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_1_2"){
							h = (Pasillo) edificio.getHabitacionPorID("p1-2");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_2_2"){
							h = (Pasillo) edificio.getHabitacionPorID("p2-2");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_1_3"){
							h = (Pasillo) edificio.getHabitacionPorID("p1-3");
							h.setBloqueado(true);
						}	
						else if(str=="chckbxPasillo_2_3"){
							h = (Pasillo) edificio.getHabitacionPorID("p2-3");
							h.setBloqueado(true);
						}	
					}
				}
					for(JCheckBox j1: chekss){
						if(j1.isSelected()){
							Escalera es;						
							String str=j1.getName();
							
							if(str=="chckbxEscalera_1_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc1-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_2_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc2-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_3_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc3-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_4_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc4-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_5_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc5-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_6_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc6-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_7_0"){
								es = (Escalera) edificio.getHabitacionPorID("esc7-0");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_1_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc1-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_2_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc2-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_3_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc3-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_4_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc4-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_5_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc5-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_6_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc6-1");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_7_1"){
								es = (Escalera) edificio.getHabitacionPorID("esc7-1");
								es.setBloqueada(true);
							}
							
							else if(str=="chckbxEscalera_3_2"){
								es = (Escalera) edificio.getHabitacionPorID("esc3-2");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_5_2"){
								es = (Escalera) edificio.getHabitacionPorID("esc5-2");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_5_2"){
								es = (Escalera) edificio.getHabitacionPorID("esc5-2");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_6_2"){
								es = (Escalera) edificio.getHabitacionPorID("esc6-2");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_8_2"){
								es = (Escalera) edificio.getHabitacionPorID("esc8-2");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_3_3"){
								es = (Escalera) edificio.getHabitacionPorID("esc3-3");
								es.setBloqueada(true);
							}
							else if(str=="chckbxEscalera_8_3"){
								es = (Escalera) edificio.getHabitacionPorID("esc8-3");
								es.setBloqueada(true);
							}
						}
					}
					
					if(chckbxBeepAscensor.isSelected()){
						Ascensor h = (Ascensor) edificio.getHabitacionPorID("asc1-0");
						h.setPitido(true);
						h = (Ascensor) edificio.getHabitacionPorID("asc1-1");
						h.setPitido(true);
						h = (Ascensor) edificio.getHabitacionPorID("asc1-2");
						h.setPitido(true);
						h = (Ascensor) edificio.getHabitacionPorID("asc1-3");
						h.setPitido(true);
					}
				InterfazManager.comenzarSimulador(edificio,edificio_2,Integer.parseInt(lblEnergiaInicialtext.getText()) , edificio.getListaHabitaciones().get(comboBox.getSelectedIndex()),edificio.getListaHabitaciones().get(comboBox_2.getSelectedIndex()),estrategia);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panel_1.add(btnAceptar, "flowx,cell 0 10");

		}
	}