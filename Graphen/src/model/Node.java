package model;

import java.util.HashSet;
import java.util.Set;


/**
 * Diese Klasse representiert ein Knoten.
 * Ein Knoten hat 
 * <li> immer eine eindeutige Nummer,
 * <li> eine X-Position,
 * <li> eine Y-Position und
 * <li> 0 bis n Kanten, die voneinnander unterschiedlich sind.
 */
public class Node {

	private static int counter = 0;
	
	private int number;
	private int x = 0;
	private int y = 0;
	
	private Set<Edge> edges = new HashSet<Edge>();;
	
	public Node() {
		
	}

	public Node(int x, int y) {
		this.number = ++counter;
		this.x = x;
		this.y = y;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	
	@Override
	public String toString() {
		return number + " = (" + x + "," + y + ")";
	}
	
	
	/** 
	 * Zwei Knoten sind unterschiedlich, wenn sie 
	 * verschiedene {@link #number} haben.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			Node other = (Node) obj;
			
			return number == other.number;
		}
		
		return super.equals(obj);
	}
	
}
