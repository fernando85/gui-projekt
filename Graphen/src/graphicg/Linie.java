package graphicg;

import java.awt.Color;

public class Linie {
	
	public int headX;
	public int tailX;
	public int headY;
	public int tailY;
	Color c = new Color(0, 0, 255);
	
	public Linie(int hx, int hy, int tx, int ty){
		headX = hx;
		tailX = tx;
		headY = hy;
		tailY = ty;
		
	}
	
	public void selected(Linie l){
		l.c= new Color(255, 0, 0);
	}
	
	public Color getColor(Linie l){
		return l.c;
	}

}
