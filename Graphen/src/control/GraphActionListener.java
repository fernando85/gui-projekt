package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.GraphActionCommand;

import view.HauptPanel;

public class GraphActionListener implements ActionListener {

	private HauptPanel hauptPanel;
	
	public GraphActionListener(HauptPanel hauptPanel) {
		this.hauptPanel = hauptPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GraphActionCommand command = GraphActionCommand.valueOf(e.getActionCommand());
		switch (command) {
		case EMPTY:
			hauptPanel.empty();
			break;
		case UNDO:
			hauptPanel.undo();
			break;
		case REDO:
			hauptPanel.redo();
			break;
		case CHECK:
			hauptPanel.check();
			break;
		case NODE:
			hauptPanel.node();
			break;
		case EDGE:
			hauptPanel.edge();
			break;
		case DELETE:
			hauptPanel.delete();
			break;
		default:
			break;
		}
	}

}
