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
	
	public void selected(){
		this.c= new Color(255, 0, 0);
	}
	
	public Color getColor(){
		return this.c;
	}

	public int getHeadX() {
		
		return this.headX;
	}

	public int getTailX() {
		
		 return this.tailX;
	}

	public int getTailY() {
		
		return this.tailY;
	}

	public int getHeadY() {
		
		return this.headY;
	}

}