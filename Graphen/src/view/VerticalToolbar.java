package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VerticalToolbar extends JToolBar {
	
	private String actionselect = "none";	
	private JToggleButton selectToggleButton;
	private JToggleButton nodeToggleButton;
	private JToggleButton edgeToggleButton;
	
	public VerticalToolbar() {
		setOrientation(SwingConstants.VERTICAL);
		initComponents();
	}
	
	
	private void initComponents() {
		selectToggleButton = new JToggleButton();
		nodeToggleButton = new JToggleButton();
		edgeToggleButton = new JToggleButton();
		
		//---- selectToggleButton ----
		selectToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/select_32.png")));
		selectToggleButton.setToolTipText("Graphelemente ausw\u00e4hlen");
		selectToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectToggleButtonActionPerformed(e);
			}
		});
		add(selectToggleButton);
		addSeparator();

		//---- nodeToggleButton ----
		nodeToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/node_32.png")));
		nodeToggleButton.setVerticalAlignment(SwingConstants.TOP);
		nodeToggleButton.setToolTipText("Knoten erstellen");
		nodeToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nodeToggleButtonActionPerformed(e);
			}
		});
		add(nodeToggleButton);
		addSeparator();

		//---- edgeToggleButton ----
		edgeToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/edge_32.png")));
		edgeToggleButton.setToolTipText("Kante erstellen.");
		edgeToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeToggleButtonActionPerformed(e);
			}
		});
		add(edgeToggleButton);
	}
	
	
	private void selectToggleButtonActionPerformed(ActionEvent e) {
		actionselect = "select";
	}

	private void nodeToggleButtonActionPerformed(ActionEvent e) {
		actionselect = "node";
	}

	private void edgeToggleButtonActionPerformed(ActionEvent e) {
		actionselect = "node";
	}
	
	public String getactionselect() {
		return actionselect;
	}
}
