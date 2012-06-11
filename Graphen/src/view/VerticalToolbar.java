package view;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import control.GraphActionCommand;
import control.GraphActionListener;

@SuppressWarnings("serial")
public class VerticalToolbar extends JToolBar {
	
	private GraphActionListener actionListener;
	
	private String actionSelect = "none";	
	private JToggleButton selectToggleButton;
	private JToggleButton nodeToggleButton;
	private JToggleButton edgeToggleButton;
	
	public VerticalToolbar(HauptPanel hauptPanel) {
		actionListener = new GraphActionListener(hauptPanel);
		setOrientation(SwingConstants.VERTICAL);
		initComponents();
	}
	
	
	private void initComponents() {
		selectToggleButton = new JToggleButton();
		nodeToggleButton = new JToggleButton();
		edgeToggleButton = new JToggleButton();
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(selectToggleButton);
		buttonGroup.add(nodeToggleButton);
		buttonGroup.add(edgeToggleButton);
		
		//---- selectToggleButton ----
		selectToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/select_32.png")));
		selectToggleButton.setToolTipText("Graphelemente auswaehlen");
		selectToggleButton.setActionCommand(GraphActionCommand.SELECT.name());
		selectToggleButton.addActionListener(actionListener);
		add(selectToggleButton);
		addSeparator();

		//---- nodeToggleButton ----
		nodeToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/node_32.png")));
		nodeToggleButton.setVerticalAlignment(SwingConstants.TOP);
		nodeToggleButton.setToolTipText("Knoten erstellen");
		nodeToggleButton.setActionCommand(GraphActionCommand.NODE.name());
		nodeToggleButton.addActionListener(actionListener);
		add(nodeToggleButton);
		addSeparator();

		//---- edgeToggleButton ----
		edgeToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/edge_32.png")));
		edgeToggleButton.setToolTipText("Kante erstellen.");
		edgeToggleButton.setActionCommand(GraphActionCommand.EDGE.name());
		edgeToggleButton.addActionListener(actionListener);
		add(edgeToggleButton);
	}
	
	
	public String getActionSelect() {
		return actionSelect;
	}
	
	public boolean isSelectButtonSelected() {
		return selectToggleButton.isSelected();
	}
	
	public boolean isNodeButtonSelected() {
		return nodeToggleButton.isSelected();
	}
	
	public boolean isEdgeButtonSelected() {
		return edgeToggleButton.isSelected();
	}
}
