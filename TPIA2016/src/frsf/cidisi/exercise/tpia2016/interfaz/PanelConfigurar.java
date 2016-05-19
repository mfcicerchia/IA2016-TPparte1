package frsf.cidisi.exercise.tpia2016.interfaz;


import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
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
	private JCheckBox chckbxPasillo_1;
	private JCheckBox chckbxPasillo_2;
	private JCheckBox chckbxPasillo_3;
	private JCheckBox chckbxPasillo_4;
	private JCheckBox chckbxPasillo_5;
	private JCheckBox chckbxPasillo_6;
	private JCheckBox chckbxPasillo_7;
	private JCheckBox chckbxPasillo_8;
	private JCheckBox chckbxPasillo_9;
	private JCheckBox chckbxPasillo_10;
	private JCheckBox chckbxPasillo_11;
	private JCheckBox chckbxPasillo_12;
	private JCheckBox chckbxPasillo_13;
	private JCheckBox chckbxPasillo_14;
	private JCheckBox chckbxPasillo_15;
	private JCheckBox chckbxPasillo_16;
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
		
		chckbxPasillo_1 = new JCheckBox("PASILLO 1");
		panel_2.add(chckbxPasillo_1, "flowx,cell 0 2");
		cheks.add(chckbxPasillo_1);
		chckbxPasillo_2 = new JCheckBox("PASILLO 2");
		panel_2.add(chckbxPasillo_2, "cell 0 2");
		cheks.add(chckbxPasillo_2);
		chckbxPasillo_3 = new JCheckBox("PASILLO 3");
		panel_2.add(chckbxPasillo_3, "cell 0 2");
		cheks.add(chckbxPasillo_3);
		chckbxPasillo_4 = new JCheckBox("PASILLO 4");
		panel_2.add(chckbxPasillo_4, "flowx,cell 0 3");
		cheks.add(chckbxPasillo_4);
		chckbxPasillo_5 = new JCheckBox("PASILLO 5");
		panel_2.add(chckbxPasillo_5, "cell 0 3");
		cheks.add(chckbxPasillo_5);
		chckbxPasillo_6 = new JCheckBox("PASILLO 6");
		panel_2.add(chckbxPasillo_6, "cell 0 3");
		cheks.add(chckbxPasillo_6);
		
		JLabel lblPrimerPiso = new JLabel("PRIMER PISO:");
		panel_2.add(lblPrimerPiso, "cell 0 4");
		
		chckbxPasillo_7 = new JCheckBox("PASILLO 1");
		panel_2.add(chckbxPasillo_7, "flowx,cell 0 5");
		cheks.add(chckbxPasillo_7);
		chckbxPasillo_8 = new JCheckBox("PASILLO 2");
		panel_2.add(chckbxPasillo_8, "cell 0 5");
		cheks.add(chckbxPasillo_8);
		chckbxPasillo_9 = new JCheckBox("PASILLO 3");
		panel_2.add(chckbxPasillo_9, "cell 0 5");
		chckbxPasillo_10 = new JCheckBox("PASILLO 4");
		cheks.add(chckbxPasillo_9);
		panel_2.add(chckbxPasillo_10, "flowx,cell 0 6");
		cheks.add(chckbxPasillo_10);
		chckbxPasillo_11 = new JCheckBox("PASILLO 5");
		panel_2.add(chckbxPasillo_11, "cell 0 6");
		cheks.add(chckbxPasillo_11);
		chckbxPasillo_12 = new JCheckBox("PASILLO 6");
		panel_2.add(chckbxPasillo_12, "cell 0 6");
		cheks.add(chckbxPasillo_12);
		
		JLabel lblSegundoPiso = new JLabel("SEGUNDO PISO:");
		panel_2.add(lblSegundoPiso, "cell 0 7");
		
		chckbxPasillo_13 = new JCheckBox("PASILLO 1");
		panel_2.add(chckbxPasillo_13, "flowx,cell 0 8");
		cheks.add(chckbxPasillo_13);
		chckbxPasillo_14 = new JCheckBox("PASILLO 2");
		panel_2.add(chckbxPasillo_14, "cell 0 8");
		cheks.add(chckbxPasillo_14);
		JLabel lblTercerPiso = new JLabel("TERCER PISO");
		panel_2.add(lblTercerPiso, "cell 0 9");
		chckbxPasillo_15 = new JCheckBox("PASILLO 1");
		panel_2.add(chckbxPasillo_15, "flowx,cell 0 10");
		cheks.add(chckbxPasillo_15);
		chckbxPasillo_16 = new JCheckBox("PASILLO 2");
		panel_2.add(chckbxPasillo_16, "cell 0 10");
		cheks.add(chckbxPasillo_16);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][][][][][][]"));
		frame.getContentPane().add(panel_3, "cell 2 0,grow");
		
		lblBloqueosEscaleras = new JLabel("BLOQUEOS ESCALERAS");
		lblBloqueosEscaleras.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblBloqueosEscaleras, "cell 0 0");
		
		lblPlantaBaja_1 = new JLabel("PLANTA BAJA:");
		panel_3.add(lblPlantaBaja_1, "cell 0 1");
		
		chckbxEscalera_1_0 = new JCheckBox("ESCALERA 1");
		panel_3.add(chckbxEscalera_1_0, "flowx,cell 0 2");
		chekss.add(chckbxEscalera_1_0);
		chckbxEscalera_2_0 = new JCheckBox("ESCALERA 2");
		panel_3.add(chckbxEscalera_2_0, "cell 0 2");
		chekss.add(chckbxEscalera_2_0);
		chckbxEscalera_3_0 = new JCheckBox("ESCALERA 3");
		panel_3.add(chckbxEscalera_3_0, "cell 0 2");
		chekss.add(chckbxEscalera_3_0);
		chckbxEscalera_4_0 = new JCheckBox("ESCALERA 4");
		panel_3.add(chckbxEscalera_4_0, "flowx,cell 0 3");
		chekss.add(chckbxEscalera_4_0);
		chckbxEscalera_5_0 = new JCheckBox("ESCALERA 5");
		panel_3.add(chckbxEscalera_5_0, "cell 0 3");
		chekss.add(chckbxEscalera_5_0);
		chckbxEscalera_6_0 = new JCheckBox("ESCALERA 6");
		panel_3.add(chckbxEscalera_6_0, "cell 0 3");
		chekss.add(chckbxEscalera_6_0);
		chckbxEscalera_7_0 = new JCheckBox("ESCALERA 7");
		panel_3.add(chckbxEscalera_7_0, "cell 0 4");
		chekss.add(chckbxEscalera_7_0);
		
		lblPrimerPiso_1 = new JLabel("PRIMER PISO:");
		panel_3.add(lblPrimerPiso_1, "cell 0 5");
		
		chckbxEscalera_1_1 = new JCheckBox("ESCALERA 1");
		panel_3.add(chckbxEscalera_1_1, "flowx,cell 0 6");
		chekss.add(chckbxEscalera_1_1);
		chckbxEscalera_2_1 = new JCheckBox("ESCALERA 2");
		panel_3.add(chckbxEscalera_2_1, "cell 0 6");
		chekss.add(chckbxEscalera_2_1);
		chckbxEscalera_3_1 = new JCheckBox("ESCALERA 3");
		panel_3.add(chckbxEscalera_3_1, "cell 0 6");
		chekss.add(chckbxEscalera_3_1);
		chckbxEscalera_4_1 = new JCheckBox("ESCALERA 4");
		panel_3.add(chckbxEscalera_4_1, "flowx,cell 0 7");
		chekss.add(chckbxEscalera_4_1);
		chckbxEscalera_5_1 = new JCheckBox("ESCALERA 5");
		panel_3.add(chckbxEscalera_5_1, "cell 0 7");
		chekss.add(chckbxEscalera_5_1);
		chckbxEscalera_6_1 = new JCheckBox("ESCLAERA 6");
		panel_3.add(chckbxEscalera_6_1, "cell 0 7");
		chekss.add(chckbxEscalera_6_1);
		chckbxEscalera_7_1 = new JCheckBox("ESCALERA 7");
		panel_3.add(chckbxEscalera_7_1, "cell 0 8");
		chekss.add(chckbxEscalera_7_1);
		
		lblSegundoPiso_1 = new JLabel("SEGUNDO PISO:");
		panel_3.add(lblSegundoPiso_1, "cell 0 9");
		
		chckbxEscalera_3_2 = new JCheckBox("ESCALERA 3");
		panel_3.add(chckbxEscalera_3_2, "cell 0 11");
		chekss.add(chckbxEscalera_3_2);
		chckbxEscalera_5_2 = new JCheckBox("ESCALERA 5");
		panel_3.add(chckbxEscalera_5_2, "flowx,cell 0 10");
		chekss.add(chckbxEscalera_5_2);
		chckbxEscalera_6_2 = new JCheckBox("ESCALERA 6");
		panel_3.add(chckbxEscalera_6_2, "cell 0 10");
		chekss.add(chckbxEscalera_6_2);
		chckbxEscalera_8_2 = new JCheckBox("ESCALERA 8");
		panel_3.add(chckbxEscalera_8_2, "cell 0 10");
		chekss.add(chckbxEscalera_8_2);

		
		lblTercerPiso_1 = new JLabel("TERCER PISO:");
		panel_3.add(lblTercerPiso_1, "cell 0 12");
		
		chckbxEscalera_3_3 = new JCheckBox("ESCALERA 3");
		panel_3.add(chckbxEscalera_3_3, "cell 0 13");
		chekss.add(chckbxEscalera_3_3);
		chckbxEscalera_8_3 = new JCheckBox("ESCALERA 8");
		panel_3.add(chckbxEscalera_8_3, "flowx,cell 0 13");
		chekss.add(chckbxEscalera_8_3);


		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int estrategia = comboBox_1.getSelectedIndex();
				int i=0;
				for(JCheckBox j: cheks){
					if(j.isSelected()){
						if(0<=i && i<=6){
							Pasillo h = (Pasillo) edificio.getHabitacionPorID("p"+(i+1)+"-0");
							h.setBloqueado(true);
						}
						else{
							if(7<=i && i<=12){
								Pasillo h = (Pasillo) edificio.getHabitacionPorID("p"+(i+1)+"-1");
								h.setBloqueado(true);
							}
							else{
								if(13<=i && i<=14){
									Pasillo h = (Pasillo) edificio.getHabitacionPorID("p"+(i+1)+"-2");
									h.setBloqueado(true);
								}
								else{
									Pasillo h = (Pasillo) edificio.getHabitacionPorID("p"+(i+1)+"-3");
									h.setBloqueado(true);
								}
							}
						}
					}
					i++;
				}
				
				 	i=0;
					for(JCheckBox j: chekss){
						if(j.isSelected()){
							if(0<=i && i<=6){
								Escalera h = (Escalera) edificio.getHabitacionPorID("esc"+(i+1)+"-0");
								h.setBloqueada(true);
							}
							else{
								if(7<=i && i<=14){
									Escalera h = (Escalera) edificio.getHabitacionPorID("esc"+(i-7+1)+"-1");
									h.setBloqueada(true);
								}
								else{
									if(15==i){
										Escalera h = (Escalera) edificio.getHabitacionPorID("esc3-2");
										h.setBloqueada(true);
									}
									else{
										if(16==i){
											Escalera h = (Escalera) edificio.getHabitacionPorID("esc5-2");
											h.setBloqueada(true);
										}
										else{
											if(17==i){
												Escalera h = (Escalera) edificio.getHabitacionPorID("esc6-2");
												h.setBloqueada(true);
											}
											else{
												if(18==i){
													Escalera h = (Escalera) edificio.getHabitacionPorID("esc8-2");
													h.setBloqueada(true);
												}
												else{
													if(19==i){
														Escalera h = (Escalera) edificio.getHabitacionPorID("esc3-3");
														h.setBloqueada(true);
													}
													else{
														Escalera h = (Escalera) edificio.getHabitacionPorID("esc8-3");
														h.setBloqueada(true);
													}
												}
											}
										}
									}
								}
							}
						}
						i++;
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
