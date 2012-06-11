package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Graph;
import model.Node;

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
	 * Diese Methode wird aufgerufen, wenn der Button 
	 * zum Fordern einer neuen Seite geklickt wurde.
	 */
	public void newSite() {
		graph = new Graph();
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Undo-Button
	 * geklickt wurde.
	 */
	public void undo() {
		// TODO
		System.out.println("undo(): Not implemented yet!");
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Redo-Button
	 * geklickt wurde.
	 */
	public void redo() {
		// TODO
		System.out.println("redo(): Not implemented yet!");
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Check-Button zum 
	 * Ueberpruefen eines Eulerkreises/-weges geklickt wurde.
	 */
	public void check() {
		// TODO
		System.out.println("check(): Not implemented yet!");
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Select-Button
	 * geklickt wurde.
	 */
	public void select() {
		// TODO
		System.out.println("select(): Not implemented yet!");
		repaint();
	}
	
	/**
	 * Ein Knoten in der Position x und y wird erzeugt und 
	 * anschliessend in den Graph eingefuegt.
	 */
	public void createNode(int x, int y) {
		Node node = new Node(x, y);
		if (node != null) {
			graph.addNode(node);
		}
		
		repaint();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Erzeugen einer neuen Kante geklickt wurde.
	 */
	public void createEdge(Node node1, Node node2) {
		// TODO
		System.out.println("createEdge(): Not implemented yet!");
		repaint();
	}
 }
