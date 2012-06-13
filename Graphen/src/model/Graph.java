package model;

import java.util.HashSet;
import java.util.Set;

import command.HistoryCommand;

public class Graph {

	private Set<Node> nodes;
	private Set<Edge> edges;
	
	private History undoHistory;
	private History redoHistory;
	
	public Graph() {
		nodes = new HashSet<Node>();
		edges = new HashSet<Edge>();
		
		undoHistory = new History();
		redoHistory = new History();
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
			undoHistory.setHistoryCommand(HistoryCommand.ADD_NODE);
			undoHistory.setGraphElement(node);
		}
		
		return nodeAdded;
	}
	
	public boolean addEdge(Edge edge) {
		boolean edgeAdded = false;
		
		if (edge != null) {
			edgeAdded = edges.add(edge);	
		}
		
		if (edgeAdded) {
			undoHistory.setHistoryCommand(HistoryCommand.ADD_EDGE);
			undoHistory.setGraphElement(edge);
		}
		
		return edgeAdded;
	}
	
	public int getNumberOfNodes() {
		return nodes.size();
	}
	
	/**
	 * @param x x-Position von dem zu suchenden Knoten.
	 * @param y y-Position von dem zu suchenden Knoten.
	 * @return Ein Knoten in der Position {@code x} und {@code y}
	 * wird zurueckgegeben.
	 */
	public Node getNode(int x, int y) {
		for (Node node : nodes) {
			// TODO: Den Knoten finden, dessen GUI-Figur auf dem Punkt (x,y) liegt.
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


	public void undo() {
		if (undoHistory != null) {
			Object graphElement = undoHistory.getGraphElement();;
			
			switch (undoHistory.getHistoryCommand()) {
			case ADD_NODE:
				if (graphElement instanceof Node) {
					Node node = (Node) graphElement;
					if (nodes.add(node)) {
						redoHistory.setHistoryCommand(HistoryCommand.DELETE_NODE);
						redoHistory.setGraphElement(node);						
					}
				}
				break;
			case DELETE_NODE:
				if (graphElement instanceof Node) {
					Node node = (Node) graphElement;
					if (nodes.remove(node)) {
						redoHistory.setHistoryCommand(HistoryCommand.ADD_NODE);
						redoHistory.setGraphElement(node);						
					}
				}
				break;
			case MOVE_NODE:
				// TODO
				break;
			case ADD_EDGE:
				if (graphElement instanceof Edge) {
					Edge edge = (Edge) graphElement;
					if (edges.add(edge)) {
						redoHistory.setHistoryCommand(HistoryCommand.DELETE_EDGE);
						redoHistory.setGraphElement(edge);						
					}
				}
				break;
			case DELETE_EDGE:
				if (graphElement instanceof Edge) {
					Edge edge = (Edge) graphElement;
					if (edges.remove(edge)) {
						redoHistory.setHistoryCommand(HistoryCommand.ADD_EDGE);
						redoHistory.setGraphElement(edge);						
					}
				}
				break;
			default:
				break;
			}
		}
	}
}
