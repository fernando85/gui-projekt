package model;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	private Set<Node> nodes;
	private Set<Edge> edges;
	
	public Graph() {
		nodes = new HashSet<Node>();
		edges = new HashSet<Edge>();
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

	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
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
}
