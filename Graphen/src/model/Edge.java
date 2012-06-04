package model;

import java.awt.Point;

public class Edge {

	private Node sourceNode;
	private Node targetNode;
	
	
	public Edge(Node sourceNode, Node targetNode) {
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
	}


	public Node getSourceNode() {
		return sourceNode;
	}


	public void setSourceNode(Node sourceNode) {
		this.sourceNode = sourceNode;
	}


	public Node getTargetNode() {
		return targetNode;
	}


	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}
	
	@Override
	public String toString() {
		return sourceNode + "---" + targetNode;
	}
}
