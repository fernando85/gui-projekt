package frames;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SimpleFrame extends JFrame implements ActionListener {




	public void showIt( int sizex, int sizey, int x, int y){


	setSize(sizex, sizey);
	setLocation(x, y);
	setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	
	}
	public SimpleFrame() {
		super("Eulerkreis");
		setSize(200, 200);
		setLocation(200, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(createMenu());
	
		setJMenuBar(menubar);
	}



	private JMenu createMenu(){
		JMenu m = new JMenu("Datei");
		m.setMnemonic('D');
		JMenuItem mi;
		mi = new JMenuItem("Einstellungen", 'f');
		setCtrlAccelerator(mi , 'O');
		mi.addActionListener(this);
		m.add(mi);
	
		return m;
	}

	private void setCtrlAccelerator(JMenuItem mi, char ctrl){
		KeyStroke ks = KeyStroke.getKeyStroke(ctrl, Event.CTRL_MASK);
		mi.setAccelerator(ks);
	}


}