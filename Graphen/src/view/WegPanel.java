package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class WegPanel extends JPanel {
	
	private JLabel weg = new JLabel("---", JLabel.CENTER);
	
	public  WegPanel(){
		setLayout (new GridLayout(8,4));
		add(new JLabel("Weg", JLabel.CENTER));
		add(weg);
	}
	
	public void zeigeWeg(){
		
	}
}
