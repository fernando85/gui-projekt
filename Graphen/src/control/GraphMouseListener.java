package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.HauptPanel;

public class GraphMouseListener extends MouseAdapter {

	private HauptPanel hauptPanel;
	
	
	public GraphMouseListener(HauptPanel hauptPanel) {
		this.hauptPanel = hauptPanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		hauptPanel.mouseClicked(e.getX(), e.getY());
	}
}
