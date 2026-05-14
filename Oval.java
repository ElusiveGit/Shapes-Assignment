/**@author Benjamin Montgomery*/
import java.awt.*;

/** @version Sets the points and color and draws an oval*/

public class Oval extends Shape {
	
	private static final long serialVersionUID = 1L;
	
	/** @param Two Point parameters to set the x and y coordinates 
	 * of two points and then a Color parameter to set the color
	 * of the shape*/

	public Oval(Point p1, Point p2, Color color, boolean nested) {
		super(p1, p2, color, nested);
		
	}
	
	/**@param Graphics to draw the shape. TODO implement method*/

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(
				getP1().x,
				getP1().y,
				getP2().x - getP1().x,
				getP2().y - getP1().y);

	}
	
	public Shape createSmaller(int dec) {
		int newX1 = getP1().x + dec;
		int newY1 = getP1().y + dec;
		int newX2 = getP2().x - dec;
		int newY2 = getP2().y- dec;
		
		return new Oval(new Point(newX1, newY1), new Point(newX2, newY2), getColor(), true);
	}

}
