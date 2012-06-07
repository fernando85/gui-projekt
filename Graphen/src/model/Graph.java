package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

	private List<Node> nodes;
	private Set<Edge> edges;
	
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

	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
}
