package model;

import java.util.HashSet;
import java.util.Set;

import command.HistoryCommand;

public class Graph {

	private Set<Node> nodes;
	private Set<Edge> edges;
	
	private History lastAction;
	
	public Graph() {
		nodes = new HashSet<Node>();
		edges = new HashSet<Edge>();
		
		lastAction = new History();
	}


	public Set<Node> getNodes() {
		return nodes;
	}


	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}


	public Set<Edge> getEdges() {
		return edges;
	}


	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public boolean addNode(Node node) {
		boolean nodeAdded = false; 
		
		if (node != null) {
			nodeAdded = nodes.add(node);
		}
		
		if (nodeAdded) {
			lastAction.setHistoryCommand(HistoryCommand.ADD_NODE);
			lastAction.setGraphElement(node);
		}
		
		return nodeAdded;
	}
	
	/**
	 * Diese Methode loescht den eingegebenen Knoten.
	 * Vorher werden alle Kanten geloescht, die den Knoten
	 * mit einem anderen Knoten verbindet.
	 * @param node Der Knoten, der geloescht wird.
	 */
	public void removeNode(Node node) {
		Set<Edge> edgesToRemove = new HashSet<Edge>();
		
		for (Edge edge : edges) {
			if (node.equals(edge.getNode1()) || node.equals(edge.getNode2())) {
				edgesToRemove.add(edge);
			}
		}
		
		// Kanten loeschen
		edges.removeAll(edgesToRemove);
		
		// Knoten loeschen
		nodes.remove(node);
	}
	
	
	public boolean addEdge(Edge edge) {
		boolean edgeAdded = false;
		
		if (edge != null) {
			edgeAdded = edges.add(edge);	
		}
		
		if (edgeAdded) {
			lastAction.setHistoryCommand(HistoryCommand.ADD_EDGE);
			lastAction.setGraphElement(edge);
		}
		
		return edgeAdded;
	}
	
	public void removeEdge(Edge edge) {
		edges.remove(edge);
	}
	
	
	/**
	 * @param x x-Position von dem zu suchenden Knoten.
	 * @param y y-Position von dem zu suchenden Knoten.
	 * @return Ein Knoten in der Position {@code x} und {@code y}
	 * wird zurueckgegeben.
	 */
	public Node getNode(int x, int y) {
		for (Node node : nodes) {
			//***********
			if(node.getX()==x && node.getY() == y)
				return node;
			//***********
			// TODO: Den Knoten finden, dessen GUI-Figur auf dem Punkt (x,y) liegt.
		}
		
		return null;
	}
	
	/**
	 * Diese Methode ueberprueft, ob ein Knoten in der Position (x,y) existiert
	 * und gibt diesen gegebenenfalls zurueck. Wenn kein Knoten in der Position
	 * (x,y) existiert, wird {@code null} zurueckgegeben.
	 * 
	 * @param x   x-Position, die ueberprueft werden muss.
	 * @param y   y-Position, die ueberprueft werden muss.
	 * @return Der Knoten in der Position (x,y) wird zurueckgegeben oder
	 *         {@code null} fuer den Fall, dass kein Knoten in der eingegebenen
	 *         Position (x,y) existiert.
	 */
	public Node getNodeAtPosition(int x, int y) {
		for (Node node : nodes) {
			if (x >= node.getX() - Node.RADIUS && x <= node.getX() + Node.RADIUS
					&& y >= node.getY() - Node.RADIUS && y <= node.getY() + Node.RADIUS) {
				return node;
			}
		}

		return null;
	}
	
	
	/**
	 * @param x x-Position von der zu suchenden Kante.
	 * @param y y-Position von der zu suchenden Kante.
	 * @return Eine Kante in der Position {@code x} und {@code y}
	 * wird zurueckgegeben.
	 */
	public Edge getEdge(int x, int y) {
		for (Edge edge : edges) {
			// TODO: Die Kante finden, deren GUI-Figur auf dem Punkt (x,y) liegt.
		}
		
		return null;
	}

	
	public void restore() {
		if (lastAction == null || lastAction.getHistoryCommand() == null) {
			return;
		}
		
		Object graphElement = lastAction.getGraphElement();
		
		switch (lastAction.getHistoryCommand()) {
		case ADD_NODE:
			if (graphElement instanceof Node) {
				Node node = (Node) graphElement;
				if (nodes.remove(node)) {
					lastAction.setHistoryCommand(HistoryCommand.DELETE_NODE);
					lastAction.setGraphElement(node);						
				}
			}
			break;
		case DELETE_NODE:
			if (graphElement instanceof Node) {
				Node node = (Node) graphElement;
				if (nodes.add(node)) {
					lastAction.setHistoryCommand(HistoryCommand.ADD_NODE);
					lastAction.setGraphElement(node);						
				}
			}
			break;
		case MOVE_NODE:
			// TODO
			break;
		case ADD_EDGE:
			if (graphElement instanceof Edge) {
				Edge edge = (Edge) graphElement;
				if (edges.remove(edge)) {
					lastAction.setHistoryCommand(HistoryCommand.DELETE_EDGE);
					lastAction.setGraphElement(edge);						
				}
			}
			break;
		case DELETE_EDGE:
			if (graphElement instanceof Edge) {
				Edge edge = (Edge) graphElement;
				if (edges.add(edge)) {
					lastAction.setHistoryCommand(HistoryCommand.ADD_EDGE);
					lastAction.setGraphElement(edge);						
				}
			}
			break;
		default:
			break;
		}
	}
}
