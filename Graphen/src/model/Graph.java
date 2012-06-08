package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<Integer, Node> nodes;
	private Set<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<Integer, Node>();
		edges = new HashSet<Edge>();
	}


	public Map<Integer, Node> getNodes() {
		return nodes;
	}


	public void setNodes(Map<Integer, Node> nodes) {
		this.nodes = nodes;
	}


	public Set<Edge> getEdges() {
		return edges;
	}


	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public void addNode(Node node) {
		nodes.put(nodes.size() + 1, node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public int getNumberOfNodes() {
		return nodes.size();
	}
}
