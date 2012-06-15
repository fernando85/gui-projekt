package view;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import command.GraphActionCommand;

import control.GraphActionListener;

@SuppressWarnings("serial")
public class VerticalToolbar extends JToolBar {
	
	private GraphActionListener actionListener;
	
	private JToggleButton nodeToggleButton;
	private JToggleButton edgeToggleButton;
	
	public VerticalToolbar(HauptPanel hauptPanel) {
		actionListener = new GraphActionListener(hauptPanel);
		
		setOrientation(SwingConstants.VERTICAL);
		initComponents();
	}
	
	
	private void initComponents() {
		nodeToggleButton = new JToggleButton();
		edgeToggleButton = new JToggleButton();
		
		//---- nodeToggleButton ----
		nodeToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/node_32.png")));
		nodeToggleButton.setVerticalAlignment(SwingConstants.TOP);
		nodeToggleButton.setToolTipText("Knoten erstellen.");
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
	
	
	/**
	 * Diese Methode ueberprueft, ob der Knopf zum Erstellen 
	 * eines Knotens geklickt ist und liefert dies zurueck.
	 * @return 
	 * <li> {@code true}, wenn der "Node"-Button geklickt ist.
	 * <li> {@code false}, andernfalls.
	 */
	public boolean isNodeButtonSelected() {
		return nodeToggleButton.isSelected();
	}
	
	/**
	 * Diese Methode ueberprueft, ob der Knopf zum Erstellen 
	 * einer Kante geklickt ist und liefert dies zurueck.
	 * @return 
	 * <li> {@code true}, wenn der "Edge"-Button geklickt ist.
	 * <li> {@code false}, andernfalls.
	 */
	public boolean isEdgeButtonSelected() {
		return edgeToggleButton.isSelected();
	}
	
	/**
	 * Diese Methode deselektiert den "Node"-Button.
	 */
	public void deselectNodeToggleButton() {
		nodeToggleButton.setSelected(false);
	}
	
	/**
	 * Diese Methode deselektiert den "Edge"-Button.
	 */
	public void deselectEdgeToggleButton() {
		edgeToggleButton.setSelected(false);
	}
	
}
