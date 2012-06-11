package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Graph;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private Graph graph = new Graph();
	
	public GraphPanel() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}


	public Graph getGraph() {
		return graph;
	}


	/**
	 * Diese Methode wird aufgerufen, wenn der Empty-Button 
	 * (zum Fordern einer neuen Seite) geklickt wurde.
	 */
	public void empty() {
		graph = new Graph();
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Undo-Button
	 * geklickt wurde.
	 */
	public void undo() {
		// TODO
		
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Redo-Button
	 * geklickt wurde.
	 */
	public void redo() {
		// TODO
		
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Check-Button zum 
	 * Ueberpruefen eines Eulerkreises/-weges geklickt wurde.
	 */
	public void check() {
		// TODO
		
	}
 }
