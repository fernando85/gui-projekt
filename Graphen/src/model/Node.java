package model;

import java.awt.Point;

@SuppressWarnings("serial")
public class Node extends Point {

	public static final int RADIUS = 5;
	
	
	public Node() {
		super();
	}

	public Node(int x, int y) {
		super(x, y);
	}

	public Node(Point p) {
		super(p);
	}



	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
