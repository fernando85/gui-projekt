package frames;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class SimpleGraphicsPanel extends JPanel {
	

	public SimpleGraphicsPanel() {
		setBackground(Color.white);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.yellow);
		g.fillRect(100, 200, 300, 200);
		g.setColor(Color.white);
		g.fillRect(150, 250, 50, 100);
		g.setColor(Color.lightGray);
		g.fillRect(250, 250, 100, 150);
		int xpoints[] = { 50, 250, 450 };
		int ypoints[] = { 250, 50, 250 };
		int npoints = 3;
		// cast to Graphics2D (in order to draw a thick line)
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5.0f));
		g2d.setColor(Color.red);
		g2d.drawPolyline(xpoints, ypoints, npoints);
	}
	
}
