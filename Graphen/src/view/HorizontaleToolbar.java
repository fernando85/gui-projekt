package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import command.GraphActionCommand;

import control.GraphActionListener;

@SuppressWarnings("serial")
public class HorizontaleToolbar extends JToolBar {

	private GraphActionListener actionListener;
	
	private JButton emptyButton;
	private JButton undoButton;
	private JButton redoButton;
	private JButton checkButton;
	
	public HorizontaleToolbar(HauptPanel hauptPanel) {
		actionListener = new GraphActionListener(hauptPanel);
		
		setFloatable(false);
		initComponents();
	}
	
	
	private void initComponents() {
		emptyButton = new JButton();
		undoButton = new JButton();
		redoButton = new JButton();
		checkButton = new JButton();
		
		//---- emptyButton ----
		emptyButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/empty_32.png")));
		emptyButton.setToolTipText("Leere Seite");
		emptyButton.setActionCommand(GraphActionCommand.EMPTY.name());
		emptyButton.addActionListener(actionListener);
		add(emptyButton);
		addSeparator();
		
		//---- undoButton ----
		undoButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/undo_32.png")));
		undoButton.setToolTipText("Undo");
		undoButton.setActionCommand(GraphActionCommand.UNDO.name());
		undoButton.addActionListener(actionListener);
		add(undoButton);
		addSeparator();

		//---- redoButton ----
		redoButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/redo_32.png")));
		redoButton.setToolTipText("Redo");
		redoButton.setEnabled(false);
		redoButton.setActionCommand(GraphActionCommand.REDO.name());
		redoButton.addActionListener(actionListener);
		add(redoButton);
		addSeparator();

		//---- checkButton ----
		checkButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		checkButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/check_32.png")));
		checkButton.setToolTipText("Pruefen auf Eulerkreis.");
		checkButton.setActionCommand(GraphActionCommand.CHECK.name());
		checkButton.addActionListener(actionListener);
		add(checkButton);
	}
	
	
	public void enableRedoButton() {
		redoButton.setEnabled(true);
		undoButton.setEnabled(false);
	}
	
	public void enableUndoButton() {
		undoButton.setEnabled(true);
		redoButton.setEnabled(false);
	}
}
