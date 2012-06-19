package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Edge;
import model.Graph;
import model.Node;
import exception.EdgeAlreadyExistException;
import exception.SameNodesException;


@SuppressWarnings("serial")
public class GraphPanel extends JPanel {
	
	private Object selectedObject;
	
	private Graph graph = new Graph();
	
	/** Der 1. Knoten fuer die Kante. */
	private Node edgeNode1;
	
	/** Der 2. Knoten fuer die Kante. */
	private Node edgeNode2;
	
	private Color basicColor = Color.BLACK;
	private Color selectedColor = new Color(0, 150, 100); 
	
	
	public GraphPanel() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Node node : graph.getNodes()) {
			if (node.equals(selectedObject)) {
				g.setColor(selectedColor);
			}
			else {
				g.setColor(basicColor);	
			}
			
			g.fillOval(
					node.getX() - Node.RADIUS, 
					node.getY() - Node.RADIUS, 
					2 * Node.RADIUS, 
					2 * Node.RADIUS
			);
		}
		
		for (Edge edge : graph.getEdges()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(2.0f));
			
			if (edge.equals(selectedObject)) {
				g2d.setColor(selectedColor);
			}
			else {
				g2d.setColor(basicColor);	
			}
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
		repaint();
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
		}
		
		if (selectedObject == null) {	// Es ist kein Knoten ausgewaehlt
			for (Edge edge : graph.getEdges()) {
				if (isEdgeClicked(x, y, edge)) {
					selectedObject = edge;
					break;
				}
			}
		}
	}
	
	private boolean isEdgeClicked(int x, int y, Edge edge) {
		// Sonderfall (node1 == node2) muss nicht beachtet werden, 
		// weil wir keine Schleife erlauben 
		
		// Hier wollen wir herausfinden, ob (x,y) auf der Kante liegt
		Point a = new Point(edge.getNode1().getX(), edge.getNode1().getY());
		Point b = new Point(edge.getNode2().getX(), edge.getNode2().getY());
		// y = mx + n
		
		double m = (double) (b.y - a.y) / (double) (b.x - a.x);
		double n = (double) a.y - (double) (m * a.x);
		
		// Nachdem m und n bekannt sind, koennen wir (x,y) auch 
		// in die Gleichung y = mx + n einsetzen
		 
		double different = y - (m*x + n);
		
		// Die Abweichung vom -2 und 2 Pixel kommt von der Kantendicke: 2.0f
		return (different >= -2 && different <= 2);
	}

	
	
	/**
	 * Ein Knoten in der Position x und y wird erzeugt und 
	 * anschliessend in den Graphen eingefuegt.
	 */
	public void createNode(int x, int y) {
		Node node = new Node(x, y);
		graph.addNode(node);
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
		catch (SameNodesException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (EdgeAlreadyExistException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
		// Nach dem Erstellen der Kante werden die ausgewahlten 
		// Knoten wieder aus null gesetzt
		resetEdgeNodes();
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
		
		selectedObject = null;
		
		repaint();
	}


	public void dragNode(Node node) {
		// TODO Auto-generated method stub
		
	}
	
}
