package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import command.GraphActionCommand;

import control.GraphActionListener;

@SuppressWarnings("serial")
public class VerticalToolbar extends JToolBar {
	
	private GraphActionListener actionListener;
	
	private JToggleButton selectToggleButton;
	private JToggleButton nodeToggleButton;
	private JToggleButton edgeToggleButton;
	private JButton deleteButton;
	
	public VerticalToolbar(HauptPanel hauptPanel) {
		actionListener = new GraphActionListener(hauptPanel);
		
		setOrientation(SwingConstants.VERTICAL);
		initComponents();
	}
	
	
	private void initComponents() {
		selectToggleButton = new JToggleButton();
		nodeToggleButton = new JToggleButton();
		edgeToggleButton = new JToggleButton();
		deleteButton = new JButton();
		
		//---- selectToggleButton ----
		selectToggleButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/select_32.png")));
		selectToggleButton.setVerticalAlignment(SwingConstants.TOP);
		selectToggleButton.setToolTipText("Auswaehlen");
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
		edgeToggleButton.setToolTipText("Kante erstellen");
		edgeToggleButton.setActionCommand(GraphActionCommand.EDGE.name());
		edgeToggleButton.addActionListener(actionListener);
		add(edgeToggleButton);
		
		//---- deleteButton ----
		deleteButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/delete_32.png")));
		deleteButton.setToolTipText("Knoten/Kante entfernen.");
		deleteButton.setEnabled(false);
		deleteButton.setActionCommand(GraphActionCommand.DELETE.name());
		deleteButton.addActionListener(actionListener);
		add(deleteButton);
	}
	
	/**
	 * Diese Methode ueberprueft, ob der Knopf zum Auswaehlen 
	 * eines Graphelementes geklickt ist und liefert dies zurueck.
	 * @return 
	 * <li> {@code true}, wenn der "Node"-Button geklickt ist.
	 * <li> {@code false}, andernfalls.
	 */
	public boolean isSelectButtonSelected() {
		return selectToggleButton.isSelected();
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
	 * Diese Methode deselektiert den "Select"-Button.
	 */
	public void deselectSelectToggleButton() {
		selectToggleButton.setSelected(false);
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
	
	
	/**
	 * Diede Methode aktiviert den "Delete"-Button, wenn der
	 * eingegebene Parameter den Wert {@code true} hat, und
	 * deaktiviert, wenn der Wert {@code false} ist.
	 * @param enable Der Wert {@code true} oder {@code false}
	 */
	public void setEnableDeleteButton(boolean enable) {
		deleteButton.setEnabled(enable);
	}
}
