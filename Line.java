/**@author Benjamin Montgomery */
import java.awt.*;

/** @version Sets the points and color and draws a line*/

public class Line extends Shape {
	
	private static final long serialVersionUID = 1L;
	
	/** @param Two Point parameters to set the x and y coordinates 
	 * of two points and then a Color parameter to set the color
	 * of the shape*/

	public Line(Point p1, Point p2, Color color, boolean nested) {
		super(p1, p2, color, nested);
		
	}

	/**@param Graphics to draw the shape. TODO implement method*/
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(
				getP1().x,
				getP1().y,
				getP2().x,
				getP2().y
				);
	}

	@Override
	public Shape createSmaller(int dec) {
		// TODO Auto-generated method stub
		return null;
	}
}
