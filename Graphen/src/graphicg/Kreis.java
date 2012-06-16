package graphicg;

import java.awt.Color;

public class Kreis {
	private int x;
	private int y;
	private int width;
	private int height;
	private int mX;
	private int mY;
	private Color c = new Color(0,255,0);
	
	
	
	public Kreis(int x, int y, int w, int h ){
		
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		
	}
	
	public void selected(){
		this.c = new Color(255,0,0);
		
	}
	
	public Color getColor(Kreis g)
	{
		return g.c;
	}
	
	public void setColor(Kreis g){
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}

	public int getHeight() {
		
		return this.height;
	}

	public int getWidth() {
		
		return this.width;
	}
	
	public void setMitPkt(int x, int y) {
		this.mX = x;
		this.mY = y;
		
	}
	
	public int getMitPktX() {
		return this.mX;
	}
	
	public int getMitPktY() {
		return this.mY;
	}
	
	

}
