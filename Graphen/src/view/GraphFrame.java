package view;

import frames.SimpleFrame;

@SuppressWarnings("serial")
public class GraphFrame extends SimpleFrame {
	
	public GraphFrame() {
		GraphPanel graphPanel = new GraphPanel();
		add(graphPanel);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GraphFrame().showIt("Graph", 500, 400, 200, 200);
	}

}
