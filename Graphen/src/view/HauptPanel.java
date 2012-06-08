/*
 * Created by JFormDesigner on Tue Jun 05 19:48:41 CEST 2012
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Graph;

/**
 * @author Fernando Luwinda
 */
@SuppressWarnings("serial")
public class HauptPanel extends JPanel {
	
	private GraphPanel graphPanel;
	private HorizontaleToolbar hToolbar;
	private VerticalToolbar vToolbar;
	
	
	public HauptPanel() {
		initComponents();
	}


	private void initComponents() {
		graphPanel = new GraphPanel();
		hToolbar = new HorizontaleToolbar(graphPanel.getGraph());
		vToolbar = new VerticalToolbar();
		
		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
		add(graphPanel, BorderLayout.CENTER);
		add(hToolbar, BorderLayout.NORTH);
		add(vToolbar, BorderLayout.WEST);
		
	}
}
