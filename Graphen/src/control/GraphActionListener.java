package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GraphPanel;

import model.Graph;

public class GraphActionListener implements ActionListener {

	private GraphPanel graphPanel;
	
	public GraphActionListener(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GraphActionCommand command = GraphActionCommand.valueOf(e.getActionCommand());
		switch (command) {
		case EMPTY:
			graphPanel.empty();
			break;
		case UNDO:
			graphPanel.undo();
			break;
		case REDO:
			graphPanel.redo();
			break;
		case NODE:
	
			break;
		case EDGE:
			
			break;
		case CHECK:
			graphPanel.check();
			break;
		case SELECT:
			
			break;
		default:
			break;
		}
	}

}
