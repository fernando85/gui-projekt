package model;

import exception.NotEulerschException;



/**
 * Diese Klasse representiert ein Knoten.
 * Ein Knoten hat 
 * <li> immer eine eindeutige Nummer,
 * <li> eine X-Position,
 * <li> eine Y-Position und
 * <li> 0 bis n Kanten, die voneinnander unterschiedlich sind.
 */
public class Node {

	public final static int RADIUS = 6;
	
	private int x = 0;
	private int y = 0;
	private int grad = 0;
	
	public Node() {
		
	}

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public void checkGrad() throws NotEulerschException {
		if(this.grad % 2 != 0)
			throw new NotEulerschException();
	}
	
	
	
	public int getGrad() {
		return this.grad;
	}
	
	public void setGrad() {
		this.grad++;
	}
	
	public void downGrad() {
		this.grad--;
	}
	
	
}
