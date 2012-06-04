package frames;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {

	public SimpleFrame() {
		setSize(200, 200);
		setLocation(200, 200);
		setTitle("mein erster Versuch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showIt(String title, int sizex, int sizey, int x, int y){
		
		setTitle(title);
		setSize(sizex, sizey);
		setLocation(x, y);
		setVisible(true);
	}
	
	
	
	
}
