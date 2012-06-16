package graphicg;

import java.awt.Color;

public class Kreis {
	public int x;
	public int y;
	public int width;
	public int height;
	Color c = new Color(0,255,0);
	
	
	
	public Kreis(int x, int y, int w, int h ){
		
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		
	}
	
	public void selected(Kreis k){
		k.c = new Color(255,0,0);
		
	}
	
	public Color getColor(Kreis g)
	{
		return g.c;
	}
	
	public void setColor(Kreis g){
		
		
		
	}
	
	

}
