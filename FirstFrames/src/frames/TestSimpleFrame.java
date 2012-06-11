package frames;

public class TestSimpleFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		SimpleFrame s = new SimpleFrame();
//		s.setVisible(true);
//		
//		SimpleFrame t = new SimpleFrame();
//		t.showIt("Gui Anwd.", 800, 800, 300, 300);
//		
		SimpleFrame s_graph = new SimpleFrame();
		s_graph.add(new SimpleGraphicsPanel());
		
		s_graph.showIt(500, 500, 0, 0);
	}

}
