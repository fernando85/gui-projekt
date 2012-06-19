package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import model.Node;

/**
 * @author Fernando Luwinda
 */
@SuppressWarnings("serial")
public class HauptPanel extends JPanel {
	
	private GraphPanel graphPanel;
	private HorizontaleToolbar hToolbar;
	private VerticalToolbar vToolbar;
	private WegPanel wegPanel;  //fuer eulerweg/kreis anzeige
	
	
	public HauptPanel() {
		initComponents();
	}


	private void initComponents() {
		graphPanel = new GraphPanel();
		hToolbar = new HorizontaleToolbar(this);
		vToolbar = new VerticalToolbar(this);
		wegPanel = new WegPanel();
		
		setLayout(new BorderLayout());

		//---- graphPanel ----
		graphPanel.setPreferredSize(new Dimension(500, 500));
		graphPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// Speichern der (x,y)-Position beim Mausklick vorm Loslassen
				int x = e.getX();
				int y = e.getY();

				// Wenn der Klickzustand vom Select-Button "an" ist,
				if (vToolbar.isSelectButtonSelected()) {
					// => dann selektiert das, was sich unter dem Mauszeiger befindet
					graphPanel.select(x, y);
				}

				// Wenn ein Knoten selektiert ist,
				if (graphPanel.getSelectedObject() instanceof Node) {
					Node node = (Node) graphPanel.getSelectedObject();
					
					// => dann bekommt er eine neue Position
					node.setX(x);
					node.setY(y);
					
					// Anschliessend den graphPanel neu zeichnen
					graphPanel.repaint();
				}
			}
		});
		graphPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				// Anfangs ist nichts selektiert, deswegen setzen wir
				// das selectedObject auf null.
				graphPanel.setSelectedObject(null);
						
				if (vToolbar.isNodeButtonSelected()) {
					graphPanel.createNode(x, y);
					
					// Der Graph hat jetzt mindestens einen Knoten
					// => Aktiviert das Undo-Button
					hToolbar.enableUndoButton();
				
					// Die selektierten Knoten fuer eine Kante
					// werden wieder auf null gesetzt.
					graphPanel.resetEdgeNodes();
				}
				else if (vToolbar.isEdgeButtonSelected()) {
					if (graphPanel.getEdgeNode1() == null) {
						// Der 1. Knoten fuer die Kante wird initialisiert
						graphPanel.initEdgeNode1(x, y);
					}
					else {
						// Der 1. Knoten fuer die Kante existiert bereits
						// => Initialisiere den 2. Knoten
						graphPanel.initEdgeNode2(x, y);
						
						if (graphPanel.getEdgeNode2() != null) {
							graphPanel.createEdge();
						}
					}
				}
				else if (vToolbar.isSelectButtonSelected()) {
					graphPanel.select(x, y);
				}
				
				// Am Ende wird der "Delete"-Button (de)aktiviert, je nachdem
				// ob ein Knoten oder Kante selektiert ist.
				vToolbar.setEnableDeleteButton(graphPanel.getSelectedObject() != null);
				
				repaint();
			}
		});
		add(graphPanel, BorderLayout.CENTER);
		add(hToolbar, BorderLayout.NORTH);
		add(vToolbar, BorderLayout.WEST);
		add(wegPanel, BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button 
	 * zum Fordern einer neuen Seite geklickt wurde.
	 */
	public void empty() {
		graphPanel.newSite();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Undo-/Redo-Button
	 * geklickt wurde.
	 */
	public void restoreGraph() {
		graphPanel.restoreGraph();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Check-Button zum 
	 * Ueberpruefen eines Eulerkreises/-weges geklickt wurde.
	 */
	public void check() {
		graphPanel.check();
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Auswaehlen eines Graphelementes geklickt wurde.
	 */
	public void select() {
		// Wenn der Knopf zum Auswaehlen eines Graphelementes geklickt ist,
		if (vToolbar.isSelectButtonSelected()) {
			// => wird der Knopf zum Erstellen einer Knoten bzw. Kante deselektiert
			vToolbar.deselectNodeToggleButton();
			vToolbar.deselectEdgeToggleButton();
			
			// und der "Delete"-Button deaktiviert.
			vToolbar.setEnableDeleteButton(false);
		}
		
		graphPanel.setSelectedObject(null);
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Erzeugen von Knoten geklickt wurde.
	 */
	public void node() {
		// Wenn der Knopf zum Erstellen eines Knotens geklickt ist,
		if (vToolbar.isNodeButtonSelected()) {
			// => wird der Knopf zum Auswaehlen und zum Erstellen 
			// einer Kante deselektiert
			vToolbar.deselectSelectToggleButton();
			vToolbar.deselectEdgeToggleButton();
			
			// und der "Delete"-Button deaktiviert.
			vToolbar.setEnableDeleteButton(false);
		}
		
		graphPanel.setSelectedObject(null);
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn der Button zum
	 * Erzeugen von Kanten geklickt wurde.
	 */
	public void edge() {
		// Wenn der Knopf zum Auswaehlen und zum Erstellen 
		// einer Kante geklickt ist,
		if (vToolbar.isEdgeButtonSelected()) {
			// => wird der Knopf zum Erstellen eines Knotens deselektiert.
			vToolbar.deselectSelectToggleButton();
			vToolbar.deselectNodeToggleButton();
			
			
			// und der "Delete"-Button deaktiviert.
			vToolbar.setEnableDeleteButton(false);
		}
		
		graphPanel.setSelectedObject(null);
	}

	
	public void delete() {
		graphPanel.deleteSelectedObject();
	}


}
