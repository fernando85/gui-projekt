package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Graph;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private Graph graph = new Graph();
	
	public GraphPanel() {
		setBackground(Color.WHITE);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}


	public Graph getGraph() {
		return graph;
	}
	
}
