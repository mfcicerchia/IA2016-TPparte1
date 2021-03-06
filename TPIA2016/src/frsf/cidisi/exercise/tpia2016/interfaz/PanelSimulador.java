package frsf.cidisi.exercise.tpia2016.interfaz;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;
import frsf.cidisi.exercise.tpia2016.search.Main;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class PanelSimulador{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame frame;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	JTextField txtPosicionAgente;
	JTextField textField_3;
	JTextPane textPane;
	JTextPane textPane_1;
	JButton btnStart;
	JTextField textField_4;
	JButton btnAutoStep;
	JButton btnPause;
	JButton btnNewSimulation;
	
	/**
	 * Create the application.
	 */
	public PanelSimulador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,fill]", "[grow]"));
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 500,750);
		panel_2.setLayout(new MigLayout("", "[grow,fill]", "[grow][][grow][][grow]"));
		frame.getContentPane().add(panel_2, "cell 0 0,grow");

		
		panel_4 = new JPanel();
		panel_4.setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][][grow][][]"));
		panel_2.add(panel_4, "cell 0 0,grow");
		
		JSeparator separator_2 = new JSeparator();
		panel_4.add(separator_2, "cell 0 0");
		
		JLabel lblEstadoDelAgente = new JLabel("ESTADO DEL AGENTE");
		lblEstadoDelAgente.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblEstadoDelAgente, "cell 0 1");
		
		JLabel lblPosiciónActual = new JLabel("POSICI\u00D3N ACTUAL");
		panel_4.add(lblPosiciónActual, "cell 0 2");
		
		textField = new JTextField();
		panel_4.add(textField, "cell 0 3,growx");
		textField.setColumns(10);
		
		JLabel lblEnergaActual = new JLabel("ENERG\u00CDA ACTUAL");
		panel_4.add(lblEnergaActual, "cell 0 4");
		
		textField_1 = new JTextField();
		panel_4.add(textField_1, "cell 0 5,growx");
		textField_1.setColumns(10);
		
		JLabel lblPosicinObjetico = new JLabel("POSICI\u00D3N OBJETICO");
		panel_4.add(lblPosicinObjetico, "cell 0 6");
		
		textField_2 = new JTextField();
		panel_4.add(textField_2, "cell 0 7,growx");
		textField_2.setColumns(10);
		
		JLabel lblSiguienteAccin = new JLabel("SIGUIENTE ACCI\u00D3N");
		panel_4.add(lblSiguienteAccin, "cell 0 8");
		
		textField_3 = new JTextField();
		panel_4.add(textField_3, "cell 0 9,growx");
		textField_3.setColumns(10);
		
		JLabel lblHabitacionesVisitadas = new JLabel("HABITACIONES VISITADAS");
		panel_4.add(lblHabitacionesVisitadas, "cell 0 10");
		
		textPane = new JTextPane();
		textPane.setText("");
		JScrollPane sp = new JScrollPane(textPane);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_4.add(sp, "flowy,cell 0 11,alignx center,growy");
		
		JLabel lblGoal = new JLabel("EXITO");
		panel_4.add(lblGoal, "cell 0 12");
		
		textField_4 = new JTextField();
		panel_4.add(textField_4, "cell 0 13,growx");
		textField_4.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		panel_2.add(separator_1, "cell 0 1");
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[grow,fill]", "[][][][][grow]"));
		panel_2.add(panel_3, "cell 0 2,grow");
		
		JLabel lblEstadoDelAmbiente = new JLabel("ESTADO DEL AMBIENTE");
		lblEstadoDelAmbiente.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEstadoDelAmbiente, "cell 0 0");
		
		JLabel lblPosicinDelAgente = new JLabel("POSICI\u00D3N DEL AGENTE:");
		panel_3.add(lblPosicinDelAgente, "cell 0 1");
		
		txtPosicionAgente = new JTextField();
		panel_3.add(txtPosicionAgente, "cell 0 2,growx");
		txtPosicionAgente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PERCEPCIONES");
		panel_3.add(lblNewLabel, "cell 0 3");
		
		textPane_1 = new JTextPane();
		JScrollPane sp2 = new JScrollPane(textPane_1);
		sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(sp2, "flowx,cell 0 4,alignx center,growy");
		
		JSeparator separator = new JSeparator();
		panel_2.add(separator, "cell 0 3");
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill]", "[grow,fill][grow,fill]"));
		panel_2.add(panel_5, "cell 0 4,grow");
		
			btnStart = new JButton("PLAY");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InterfazManager.setAutoStep(btnStart.isEnabled());
					if (btnStart.isEnabled()) {
						btnStart.setEnabled(false);
						btnPause.setEnabled(true);
					} else {
						btnStart.setEnabled(true);
						btnPause.setEnabled(false);
					}
				}
			});
			panel_5.add(btnStart, "flowx,cell 0 0");
			
			btnPause = new JButton("PAUSE");
			btnPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InterfazManager.setAutoStep(!btnPause.isEnabled());
					if (btnPause.isEnabled()) {
						btnStart.setEnabled(true);
						btnPause.setEnabled(false);
					} else {
						btnStart.setEnabled(false);
						btnPause.setEnabled(true);
					}
				}
			});
			
			panel_5.add(btnPause, "cell 1 0");
			
		JPanel panel_1 = new PanelCanvas();
		frame.getContentPane().add(panel_1, "cell 1 0,grow");
		
		panel_6 = new PanelCanvas();
		JLabel lblLabel_1 = new JLabel("");
		ImageIcon im = new ImageIcon("images\\pbaja.png");
		Image imsc = im.getImage().getScaledInstance(550, 695, Image.SCALE_DEFAULT);
		lblLabel_1.setIcon( new ImageIcon(imsc));
		panel_6.add(lblLabel_1);
		panel_6.addMouseListener(new MouseAdapter() {
		    public void mousePressed( MouseEvent evt ) {
		        ((PanelCanvas)evt.getComponent()).posicionX = evt.getX();
		        ((PanelCanvas)evt.getComponent()).posicionY = evt.getY();
		        }
		});
		panel_6.setVisible(true);
		panel_1.add(panel_6);

		
		panel_7 = new PanelCanvas();
		JLabel lblLabel_2 = new JLabel("");
		im = new ImageIcon("images\\p1.png");
		imsc = im.getImage().getScaledInstance(550, 695, Image.SCALE_DEFAULT);
		lblLabel_2.setIcon( new ImageIcon(imsc));
		panel_7.add(lblLabel_2);
		panel_7.addMouseListener(new MouseAdapter() {
		    public void mousePressed( MouseEvent evt ) {
		        ((PanelCanvas)evt.getComponent()).posicionX = evt.getX();
		        ((PanelCanvas)evt.getComponent()).posicionY = evt.getY();
		        }
		});
		panel_7.setVisible(false);
		panel_1.add(panel_7);
		
		panel_8 = new PanelCanvas();
		JLabel lblLabel_3 = new JLabel("");
		im = new ImageIcon("images\\p2.png");
		imsc = im.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		lblLabel_3.setIcon( new ImageIcon(im.getImage()));
		panel_8.add(lblLabel_3);
		panel_8.addMouseListener(new MouseAdapter() {
		    public void mousePressed( MouseEvent evt ) {
		        ((PanelCanvas)evt.getComponent()).posicionX = evt.getX();
		        ((PanelCanvas)evt.getComponent()).posicionY = evt.getY();
		        }
		});
		panel_8.setVisible(false);
		panel_1.add(panel_8);
		
		panel_9 = new PanelCanvas();
		JLabel lblLabel_4 = new JLabel("");
		im = new ImageIcon("images\\p3.png");
		imsc = im.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		lblLabel_4.setIcon( new ImageIcon(im.getImage()));
		panel_9.add(lblLabel_4);
		panel_9.addMouseListener(new MouseAdapter() {
		    public void mousePressed( MouseEvent evt ) {
		        ((PanelCanvas)evt.getComponent()).posicionX = evt.getX();
		        ((PanelCanvas)evt.getComponent()).posicionY = evt.getY();
		        }
		});
		panel_9.setVisible(false);
		panel_1.add(panel_9);
	
		
		JButton buttonAnterior = new JButton("PREVIOUS IMAGE");
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.isVisible()){
					panel_6.setVisible(false);
					panel_7.setVisible(true);
				}
				else if(panel_7.isVisible()){
					panel_7.setVisible(false);
					panel_8.setVisible(true);
				}
				else if(panel_8.isVisible()){
					panel_8.setVisible(false);
					panel_9.setVisible(true);
				}
				else{
					panel_6.setVisible(true);
					panel_9.setVisible(false);
				}
			}
		});
		
		btnAutoStep = new JButton("AUTO STEP");
		btnAutoStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazManager.avanzar2();
			}
		});
		
		
		panel_5.add(btnAutoStep, "cell 2 0");
		panel_5.add(buttonAnterior, "flowx,cell 0 1");
		
		JButton btnSiguiente = new JButton("NEXT IMAGE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.isVisible()){
					panel_6.setVisible(false);
					panel_7.setVisible(true);
				}
				else if(panel_7.isVisible()){
					panel_7.setVisible(false);
					panel_8.setVisible(true);
				}
				else if(panel_8.isVisible()){
					panel_8.setVisible(false);
					panel_9.setVisible(true);
				}
				else{
					panel_6.setVisible(true);
					panel_9.setVisible(false);
				}
			}
		});
		panel_5.add(btnSiguiente, "cell 1 1");		
		
		btnNewSimulation = new JButton("NEW SIMULATION");
		btnNewSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			InterfazManager.close();			
			}
		});
		
		panel_5.add(btnNewSimulation, "cell 2 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	public void terminar() {
		btnStart.setEnabled(false);
		btnStart.setSelected(false);
	}
	
	public void dibujarAgente(Point posicion, int nivel){

		switch(nivel){
		case 0:
			panel_6.setVisible(true);
			panel_7.setVisible(false);
			panel_8.setVisible(false);
			panel_9.setVisible(false);
			((PanelCanvas) panel_6).setPosicionX(posicion.x);
			((PanelCanvas) panel_6).setPosicionY(posicion.y);
		break;
		case 1:
			panel_6.setVisible(false);
			panel_7.setVisible(true);
			panel_8.setVisible(false);
			panel_9.setVisible(false);
			((PanelCanvas) panel_7).setPosicionX(posicion.x);
			((PanelCanvas) panel_7).setPosicionY(posicion.y);
		break;
		case 2:
			panel_6.setVisible(false);
			panel_7.setVisible(false);
			panel_8.setVisible(true);
			panel_9.setVisible(false);
			((PanelCanvas) panel_8).setPosicionX(posicion.x);
			((PanelCanvas) panel_8).setPosicionY(posicion.y);
		break;
		case 3:
			panel_6.setVisible(false);
			panel_7.setVisible(false);
			panel_8.setVisible(false);
			panel_9.setVisible(true);
			((PanelCanvas) panel_9).setPosicionX(posicion.x);
			((PanelCanvas) panel_9).setPosicionY(posicion.y);
		break;
		}
	}

}
