package model;

import java.awt.Point;
import java.util.List;

@SuppressWarnings("serial")
public class Node extends Point {

	private List<Edge> edges;
	
	public Node() {
		super();
	}

	public Node(int x, int y) {
		super(x, y);
	}

	public Node(Point p) {
		super(p);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
