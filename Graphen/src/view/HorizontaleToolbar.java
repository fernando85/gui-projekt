package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class HorizontaleToolbar extends JToolBar {

	private HauptPanel hauptPanel;
	
	private JButton emptyButton;
	private JButton undoButton;
	private JButton redoButton;
	private JButton checkButton;
	
	public HorizontaleToolbar(HauptPanel hauptPanel) {
		this.hauptPanel = hauptPanel;
		
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
		emptyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hauptPanel.empty();
			}
		});
		add(emptyButton);
		addSeparator();
		
		//---- undoButton ----
		undoButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/undo_32.png")));
		undoButton.setToolTipText("Undo");
		undoButton.setEnabled(false);
		undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hauptPanel.restoreGraph();
				
				redoButton.setEnabled(true);
				undoButton.setEnabled(false);
			}
		});
		add(undoButton);
		addSeparator();

		//---- redoButton ----
		redoButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/redo_32.png")));
		redoButton.setToolTipText("Redo");
		redoButton.setEnabled(false);
		redoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hauptPanel.restoreGraph();
				
				undoButton.setEnabled(true);
				redoButton.setEnabled(false);
			}
		});
		add(redoButton);
		addSeparator();

		//---- checkButton ----
		checkButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		checkButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/check_32.png")));
		checkButton.setToolTipText("Pruefen auf Eulerkreis.");
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hauptPanel.check();
			}
		});
		add(checkButton);
	}


	public void enableUndoButton() {
		undoButton.setEnabled(true);
	}
	
}