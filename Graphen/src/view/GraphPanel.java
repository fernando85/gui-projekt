package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exception.SameNodesException;

import model.Edge;
import model.Graph;
import model.Node;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private Graph graph = new Graph();
	
	/** Der 1. Knoten fuer die Kante. */
	private Node edgeNode1;
	
	/** Der 2. Knoten fuer die Kante. */
	private Node edgeNode2;
	
	public GraphPanel() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// TODO
	}


	public Graph getGraph() {
		return graph;
	}

	
	public Node getEdgeNode1() {
		return edgeNode1;
	}
	
	public Node getEdgeNode2() {
		return edgeNode2;
	}
	
	public void initEdgeNode1(int x, int y) {
		edgeNode1 = graph.getNode(x, y);
	}
	
	public void initEdgeNode2(int x, int y) {
		edgeNode2 = graph.getNode(x, y);
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button "Auswaehlen"
	 * oder "Knoten erstellen" in GUI gedrueckt wird.
	 */
	public void resetEdgeNodes() {
		edgeNode1 = null;
		edgeNode2 = null;
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
	 * Diese Methode stellt den alten Graphzustand wieder.
	 */
	public void restoreGraph() {
		graph.restore();
		
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
	public void select(int x, int y) {
		Node selectedNode = graph.getNode(x, y);
		if (selectedNode != null) {
			// TODO: Selektierer Knoten in GUI erkennbar machen 
			// (z.B. durch andere Farbe oder durch dickere Raender)
		}
		else {
			Edge selectedEdge = graph.getEdge(x, y);
			if (selectedEdge != null) {
				// TODO: Selektiere Kante in GUI erkennbar machen
				// (z.B. durch andere Farbe oder durch dickere Raender)
			}
		}
		
		repaint();
	}
	
	
	/**
	 * Ein Knoten in der Position x und y wird erzeugt und 
	 * anschliessend in den Graphen eingefuegt.
	 */
	public void createNode(int x, int y) {
		Node node = new Node(x, y);
		graph.addNode(node);
		
		repaint();
	}
	
	/**
	 * Eine Kante zwischen {@link #edgeNode1} und {@link #edgeNode2}
	 * wird erzeugt und anschliessend in den Graphen eingefuegt.
	 * Falls die beiden Knoten gleich sind, wird ein Dialogfenster
	 * gezeigt mit der Meldung, dass die beiden Knoten unterschiedlich
	 * sein muessen.
	 */
	public void createEdge() {
		try {
			Edge edge = new Edge(edgeNode1, edgeNode2);
			graph.addEdge(edge);
		} 
		catch (SameNodesException e) {
			JOptionPane.showMessageDialog(null, "Die beiden Knoten muessen unterschiedlich sein!");
		}
		
		repaint();
	}
 }
