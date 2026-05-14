/** @author Benjamin Montgomery
	@version Abstract class to set up drawing of different shapes within subclasses*/

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Point p1, p2;
	private Color color;
	private boolean nested;
	
	/** @param Two Point parameters to set the x and y coordinates 
	 * of two points and then a Color parameter to set the color
	 * of the shape*/
	
	Shape(Point p1, Point p2, Color color, boolean nested) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;	
		this.nested = nested;
	}

	/**@return xy coordinate for Point p1*/
	public Point getP1() {
		return p1;
	}

	/**@param sets the xy coordinate for Point p1*/
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	/**@return xy coordinate for Point p2*/
	public Point getP2() {
		return p2;
	}
	/**@param sets the xy coordinate for Point p2*/
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	/**@return color for the shape*/
	public Color getColor() {
		return color;
	}
	/**@param sets the color for the shape*/
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean getNested() {
		return nested;
	}
	
	public void setNested(boolean nested) {
		this.nested = nested;
	}
	
	public int getWidth() {
		return (getP2().x - getP1().x);
	}
	
	public int getHeight() {
		return (getP2().y - getP1().y);
	}
		/** @param Graphics to draw the shape
		 * Abstract method for the subclasses*/
	public abstract void draw(Graphics g);
	
	public abstract Shape createSmaller(int dec);
	
}
