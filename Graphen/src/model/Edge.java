package model;

import exception.SameNodesException;


/**
 * Diese Klasse representiert eine Kante.
 * Eine Kante verbindet immer 2 unterschiedlichen Knoten.
 * Darum hat diese Klasse keinen einfachen Konstruktor
 * ohne Eingabeparameter. 
 */
public class Edge {

	private Node node1;
	private Node node2;
	
	
	public Edge(Node node1, Node node2) throws SameNodesException {
		if (node1.equals(node2)) {
			throw new SameNodesException();
		}
		
		this.node1 = node1;
		this.node2 = node2;
	}


	public Node getNode1() {
		return node1;
	}


	public void setNode1(Node node1) {
		this.node1 = node1;
	}


	public Node getNode2() {
		return node2;
	}


	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	
	@Override
	public String toString() {
		return node1 + "---" + node2;
	}
	
	
	/**
	 * Zwei Kanten sind gleich, wenn die Knoten gleich sind, die von 
	 * den beiden Kanten gespeichert sind.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Edge) {
			Edge other = (Edge) obj;
			
			return 
				(node1.equals(other.node1) && node2.equals(other.node2))
				||
				(node1.equals(other.node2) && node2.equals(other.node1));
		}
		
		return super.equals(obj);
	}
}
