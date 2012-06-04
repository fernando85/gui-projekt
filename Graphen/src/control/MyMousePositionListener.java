package control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Node;

import view.GraphPanel;

public class MyMousePositionListener extends MouseAdapter {

	private GraphPanel graphPanel;
	
	private Node sourceNode;
	private Node targetNode;
	
	public MyMousePositionListener(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		Node node = graphPanel.addNode(new Node(x, y));
		if (sourceNode == null) {
			sourceNode = node;
		}
		else if (sourceNode.x != node.x && sourceNode.y != node.y) {
			targetNode = node;
		}
		
		if (sourceNode != null && targetNode != null) {
			graphPanel.addEdge(sourceNode, targetNode);
			sourceNode = null;
			targetNode = null;
		}
		
		graphPanel.repaint();
	}

}
