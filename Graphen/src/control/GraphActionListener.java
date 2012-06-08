package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Graph;

public class GraphActionListener implements ActionListener {

	private Graph graph;
	
	public GraphActionListener(Graph graph) {
		this.graph = graph;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GraphActionCommand command = GraphActionCommand.valueOf(e.getActionCommand());
		switch (command) {
		case EMPTY:
			graph = new Graph();
			break;
		case UNDO:
			
			break;
		case REDO:
	
			break;
		case NODE:
	
			break;
		case EDGE:
			
			break;
		case CHECK:
			
			break;
		case SELECT:
			
			break;
		default:
			break;
		}
	}

}
