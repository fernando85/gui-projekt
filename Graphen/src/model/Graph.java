package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

	private List<Node> nodes;
	private Set<Edge> edges;
	
	private Node currentNode;
	
	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new HashSet<Edge>();
	}


	public List<Node> getNodes() {
		return nodes;
	}


	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}


	public Set<Edge> getEdges() {
		return edges;
	}


	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}
	
	
	public Node getActualNode() {
		return currentNode;
	}


	public void setActualNode(Node actualNode) {
		this.currentNode = actualNode;
	}


	/**
	 * Diese Methode fuegt einen Knoten in dem Graphen, wenn
	 * ein Knoten in der Position von {@code node} noch nicht
	 * existiert und aktualisiert den aktuellen Knoten (zuletzt
	 * geklickten Knoten im Graphen). 
	 * @param node Der Knoten, der zu dem Graph hinzugefuegt
	 * werden soll.
	 */
	public void addNode(Node node) {
		Node existNode = getNodeAtPosition(node.x, node.y);
		if (existNode == null) {
			nodes.add(node);
			currentNode = node;
		}
		else {
			currentNode = existNode;
		}
	}
	
	public boolean addEdge(Edge edge) {
		return edges.add(edge);
	}
	
	
	/**
	 * Diese Methode ueberprueft, ob ein Knoten in der Position (x,y)
	 * existiert und gibt diesen gegebenenfalls zurueck. Wenn kein
	 * Knoten in der Position (x,y) existiert, wird {@code null}
	 * zurueckgegeben.
	 * @param x x-Position, die ueberprueft werden muss.
	 * @param y y-Position, die ueberprueft werden muss.
	 * @return Der Knoten in der Position (x,y) wird zurueckgegeben
	 * oder {@code null} fuer den Fall, dass kein Knoten in der
	 * eingegebenen Position (x,y) existiert.
	 */
	private Node getNodeAtPosition(int x, int y) {
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (x >= node.x - Node.RADIUS && x <= node.x + Node.RADIUS
					&& y >= node.y - Node.RADIUS && y <= node.y + Node.RADIUS) {
				return node;
			}
		}
		
		return null;
	}
	
}
