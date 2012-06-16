package view.figure;

import java.awt.Color;
import java.awt.Point;

import model.Node;

public class NodeFigure {

	public static final int RADIUS = 10;
	
	private Point center;
	private Color color = Color.GREEN;	// Farbe: Grün
	
	
	public NodeFigure(Node node) {
		center = new Point(node.getX(), node.getY());
	}
	
	
	public int getX() {
		return center.x;
	}
	
	public int getY() {
		return center.y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void selected() {
		color = Color.RED;		// Farbe: Rot
	}
	

}
