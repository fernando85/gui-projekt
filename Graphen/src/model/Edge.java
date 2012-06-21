package model;

import java.awt.Color;

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
	private Color col = Color.black;
	
	
	public Edge(Node node1, Node node2) throws SameNodesException {
		if (node1.equals(node2)) {
			throw new SameNodesException();
		}
		
		this.node1 = node1;
		this.node1.setGrad();//******************
		this.node2 = node2;
		this.node2.setGrad();//*************
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node1 == null) ? 0 : node1.hashCode());
		result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Edge other = (Edge) obj;
		if (node1 == null) {
			if (other.node1 != null)
				return false;
		} else if (!node1.equals(other.node1))
			return false;
		if (node2 == null) {
			if (other.node2 != null)
				return false;
		} else if (!node2.equals(other.node2))
			return false;
		return true;
	}
	
	public void setColor() {
		this.col = Color.red;
	}
	
	public Color getColor() {
		return this.col;
	}
	
	
}
