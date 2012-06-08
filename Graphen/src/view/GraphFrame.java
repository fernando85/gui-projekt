package view;

import frames.SimpleFrame;

@SuppressWarnings("serial")
public class GraphFrame extends SimpleFrame {
	
	public GraphFrame() {
		HauptPanel hauptPanel = new HauptPanel();
		add(hauptPanel);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GraphFrame().showIt( 500, 400, 200, 200);
	}

}
