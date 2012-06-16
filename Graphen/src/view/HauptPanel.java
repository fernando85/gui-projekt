/*
 * Created by JFormDesigner on Tue Jun 05 19:48:41 CEST 2012
 */

package view;

import graphicg.Kreis;
import graphicg.Linie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import control.GraphMouseListener;

/**
 * @author Fernando Luwinda
 */
@SuppressWarnings("serial")
public class HauptPanel extends JPanel {
	
	private ArrayList<Kreis> kreisList =new ArrayList<Kreis>();
	private Kreis kNode = new Kreis(0,0,0,0);
	
	private ArrayList<Linie> linieList =new ArrayList<Linie>();
	private Linie lEdge = new Linie(0,0,0,0);
	
	private Kreis head1 = null;
	private Kreis tail1 = null;
	
	
	
	
	
	private GraphPanel graphPanel;
	private HorizontaleToolbar hToolbar;
	private VerticalToolbar vToolbar;
	//private WegPanel wegPanel;  //fuer eulerweg/kreis anzeige
	
	
	public HauptPanel() {
		initComponents();
		
		
	}


	private void initComponents() {
		graphPanel = new GraphPanel(kreisList, linieList);
		hToolbar = new HorizontaleToolbar(this);
		vToolbar = new VerticalToolbar(this);
		//wegPanel = new WegPanel();
		
		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
		graphPanel.addMouseListener(new GraphMouseListener(this));
		add(graphPanel, BorderLayout.CENTER);
		add(hToolbar, BorderLayout.NORTH);
		add(vToolbar, BorderLayout.WEST);
		//add(wegPanel, BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button 
	 * zum Fordern einer neuen Seite geklickt wurde.
	 */
	public void empty() {
		graphPanel.newSite();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Undo-Button
	 * geklickt wurde.
	 */
	public void undo() {
		graphPanel.restoreGraph();
		hToolbar.enableRedoButton();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Redo-Button
	 * geklickt wurde.
	 */
	public void redo() {
		graphPanel.restoreGraph();
		hToolbar.enableUndoButton();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Check-Button zum 
	 * Ueberpruefen eines Eulerkreises/-weges geklickt wurde.
	 */
	public void check() {
		graphPanel.check();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Erzeugen von Knoten geklickt wurde.
	 */
	public void node() {
		// Wenn der Knopf zum Erstellen eines Knotens geklickt ist,
		if (vToolbar.isNodeButtonSelected()) {
			// => wird der Knopf zum Erstellen einer Kante deselektiert.
			vToolbar.deselectEdgeToggleButton();
		}
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Erzeugen von Kanten geklickt wurde.
	 */
	public void edge() {
		// Wenn der Knopf zum Erstellen einer Kante geklickt ist,
		if (vToolbar.isEdgeButtonSelected()) {
			// => wird der Knopf zum Erstellen eines Knotens deselektiert.
			vToolbar.deselectNodeToggleButton();
		}
	}
	

	public void mouseClicked(int x, int y) {
		if (vToolbar.isNodeButtonSelected()) {
			
			if(graphPanel.searchGNode(x, y)== null){
				kNode = new Kreis(x-10,y-10,2*10-1,2*10-1);
				kNode.setMitPkt(x, y);
				kreisList.add(kNode);
			
				graphPanel.createNode(kNode.getMitPktX(), kNode.getMitPktY());
			
			// Der Graph hat jetzt mindestens einen Knoten
			// => Aktiviert das Undo-Button
				hToolbar.enableUndoButton();
			
			// Die selektierten Knoten fuer eine Kante
			// werden wieder auf null gesetzt.
				graphPanel.resetEdgeNodes();
			}
			else{
				System.out.println("falsch");
			}
		}
		else if (vToolbar.isEdgeButtonSelected()) {
			
			
			
			if(head1 == null){
				head1 = graphPanel.searchGNode(x, y);
				
			}
			else {
				tail1 = graphPanel.searchGNode(x, y);
				if(tail1 != head1){
					lEdge = new Linie(head1.getMitPktX(), head1.getMitPktY(), tail1.getMitPktX(),tail1.getMitPktY());
					linieList.add(lEdge);
				
					head1= null;
					tail1 = null;
				}
				else
				{
					tail1 = null;
				}
			}
			
		}
			
			
//			if (graphPanel.getEdgeNode1() == null) {
//				// Der 1. Knoten fuer die Kante wird initialisiert
//				graphPanel.initEdgeNode1(x, y);
//			}
//			else {
//				// Der 1. Knoten fuer die Kante existiert bereits
//				// => Initialisiere den 2. Knoten
//				graphPanel.initEdgeNode2(x, y);
//				
//				if (graphPanel.getEdgeNode2() != null) {
//					graphPanel.createEdge();
//				}
//			}
//		}
		else {
			graphPanel.select(x, y);
		}
		repaint();//*******************************************
	}
	

}
		
		
	
	
	


