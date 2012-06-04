package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import model.Edge;
import model.Graph;
import model.Node;
import control.MyMousePositionListener;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private Graph graph = new Graph();
	
	private MyMousePositionListener listener = new MyMousePositionListener(this);
	
	
	public GraphPanel() {
		setBackground(Color.WHITE);
		addMouseListener(listener);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < graph.getNodes().size(); i++) {
			Node node = graph.getNodes().get(i);
			g.setColor(Color.BLACK);
			g.fillOval(
					node.x - Node.RADIUS, 
					node.y - Node.RADIUS, 
					2 * Node.RADIUS, 
					2 * Node.RADIUS);
		}
		
		for (Edge edge : graph.getEdges()) {
			Node sourceNode = edge.getSourceNode();
			Node targetNode = edge.getTargetNode();
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.setColor(Color.BLACK);
			g2d.drawLine(sourceNode.x, sourceNode.y, targetNode.x, targetNode.y);
		}
	}


	public Node addNode(Node node) {
		graph.addNode(node);
		return graph.getActualNode();
	}


	public void addEdge(Node sourceNode, Node targetNode) {
		Edge edgeToAdd = new Edge(sourceNode, targetNode);
		graph.addEdge(edgeToAdd);
	}
	
}
