package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Edge;
import model.Graph;
import model.Node;
import exception.SameNodesException;


@SuppressWarnings("serial")
public class GraphPanel extends JPanel {
	
	private Object selectedObject;
	
	private Graph graph = new Graph();
	
	/** Der 1. Knoten fuer die Kante. */
	private Node edgeNode1;
	
	/** Der 2. Knoten fuer die Kante. */
	private Node edgeNode2;
	
	private Color basicColor = new Color(0, 150, 100);
	
	
	public GraphPanel() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Node node : graph.getNodes()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.setColor(basicColor);
			g2d.fillOval(
					node.getX() - Node.RADIUS, 
					node.getY() - Node.RADIUS, 
					2 * Node.RADIUS, 
					2 * Node.RADIUS
			);
		}
		
		for (Edge edge : graph.getEdges()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.setColor(basicColor);
			g2d.drawLine(edge.getNode1().getX(), edge.getNode1().getY(), 
					edge.getNode2().getX(), edge.getNode2().getY());
		}
		
	}


	public Graph getGraph() {
		return graph;
	}
	
	
	public Object getSelectedObject() {
		return selectedObject;
	}
	
	public void setSelectedObject(Object o) {
		selectedObject = o;
	}

	
	public Node getEdgeNode1() {
		return edgeNode1;
	}
	
	public Node getEdgeNode2() {
		return edgeNode2;
	}
	
	public void initEdgeNode1(int x, int y) {
		edgeNode1 = graph.getNodeAtPosition(x, y);
	}
	
	public void initEdgeNode2(int x, int y) {
		edgeNode2 = graph.getNodeAtPosition(x, y);
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
		selectedObject = graph.getNodeAtPosition(x, y);
		if (selectedObject == null) {
			selectedObject = graph.getEdge(x, y);
			if (selectedObject != null) {
				// TODO: Selektierer Knoten in GUI erkennbar machen 
				// (z.B. durch andere Farbe oder durch dickere Raender)
			}
		
			else {
				selectedObject = graph.getEdge(x, y);
				if (selectedObject != null) {
					// TODO: Selektiere Kante in GUI erkennbar machen
					// (z.B. durch andere Farbe oder durch dickere Raender)
				}
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
			
			// Nach dem Erstellen der Kante werden die ausgewahlten 
			// Knoten wieder aus null gesetzt
			resetEdgeNodes();
		} 
		catch (SameNodesException e) {
			JOptionPane.showMessageDialog(null, "Die beiden Knoten muessen unterschiedlich sein!");
		}
		
		repaint();
	}
	
	
	public void deleteSelectedObject() {
		if (selectedObject == null) {
			return;
		}
		
		if (selectedObject instanceof Node) {
			graph.removeNode((Node) selectedObject);
		}
		else if (selectedObject instanceof Edge) {
			graph.removeEdge((Edge) selectedObject);
		}
		
		repaint();
	}
	
}
