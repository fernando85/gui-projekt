/*
 * Created by JFormDesigner on Tue Jun 05 19:48:41 CEST 2012
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Fernando Luwinda
 */
@SuppressWarnings("serial")
public class HauptPanel extends JPanel {
	
	private GraphPanel graphPanel;
	private HorizontaleToolbar hToolbar;
	private VerticalToolbar vToolbar;
	//sprivate WegPanel wegPanel;  //fuer eulerweg/kreis anzeige
	
	
	public HauptPanel() {
		initComponents();
	}


	private void initComponents() {
		graphPanel = new GraphPanel();
		hToolbar = new HorizontaleToolbar(graphPanel);
		vToolbar = new VerticalToolbar();
		//wegPanel = new WegPanel();
		
		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
		add(graphPanel, BorderLayout.CENTER);
		add(hToolbar, BorderLayout.NORTH);
		add(vToolbar, BorderLayout.WEST);
		//add(wegPanel, BorderLayout.SOUTH);
		
	}
}
