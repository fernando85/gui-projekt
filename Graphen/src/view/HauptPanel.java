/*
 * Created by JFormDesigner on Tue Jun 05 19:48:41 CEST 2012
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
		hToolbar = new HorizontaleToolbar();
		vToolbar = new VerticalToolbar();

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
		add(graphPanel, BorderLayout.CENTER);
		add(hToolbar, BorderLayout.NORTH);
		add(vToolbar, BorderLayout.WEST);
		
	}
}
