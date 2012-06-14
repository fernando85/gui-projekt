/*
 * Created by JFormDesigner on Tue Jun 05 19:48:41 CEST 2012
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Fernando Luwinda
 */
@SuppressWarnings("serial")
public class HauptPanel extends JPanel {
	
	private GraphPanel graphPanel;
	private HorizontaleToolbar hToolbar;
	private VerticalToolbar vToolbar;
	//private WegPanel wegPanel;  //fuer eulerweg/kreis anzeige
	
	
	public HauptPanel() {
		initComponents();
	}


	private void initComponents() {
		graphPanel = new GraphPanel();
		hToolbar = new HorizontaleToolbar(this);
		vToolbar = new VerticalToolbar(this);
		//wegPanel = new WegPanel();
		
		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
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
		graphPanel.undo();
		hToolbar.enableRedoButton();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Redo-Button
	 * geklickt wurde.
	 */
	public void redo() {
		graphPanel.redo();
		hToolbar.enableUndoButton();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Check-Button zum 
	 * Ueberpruefen eines Eulerkreises/-weges geklickt wurde.
	 */
	public void check() {
		graphPanel.check();
	}
	

	public void mouseClicked(int x, int y) {
		if (vToolbar.isNodeButtonSelected()) {
			graphPanel.resetEdgeNodes();
			
			graphPanel.createNode(x, y);
			
			// Aktiviert das Undo-Button erst, wenn 
			// der Graph zumindest einen Knoten hat.
			hToolbar.enableUndoButton();
		}
		else if (vToolbar.isEdgeButtonSelected()) {
			if (graphPanel.getEdgeNode1() == null) {
				// Der 1. Knoten fuer die Kante wird initialisiert
				graphPanel.initEdgeNode1(x, y);
			}
			else {
				// Der 1. Knoten fuer die Kante existiert bereits
				// => Initialisiere den 2. Knoten
				graphPanel.initEdgeNode2(x, y);
				
				if (graphPanel.getEdgeNode2() != null) {
					graphPanel.createEdge();
				}
			}
		}
		else {
			graphPanel.select(x, y);
		}
	}
}
