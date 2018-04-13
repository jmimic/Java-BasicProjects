/*
 *	===============================================================================
 *  Coder: Jacky Shew
 *	MovingRectangle.java : A shape that is a rectangle.
 *	A rectangle has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */
import java.awt.*;
public class MovingRectangle extends MovingShape {

	/** constructor to create a rectangle with default values
	 */
	public MovingRectangle() {
		super();
	}

	/** constructor to create a rectangle shape
	 */
	public MovingRectangle(int x, int y, int w, int h, float pw,  int mw, int mh, Color bc, int pathType) {
		super(x ,y ,w ,h ,pw ,mw ,mh ,bc, pathType);
	}

	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(penWidth));
		g2d.setPaint(borderColor);
		g2d.drawRect(p.x, p.y, width, height);
		drawHandles(g);
	}

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		int sideLength = (Math.min(width, height));
		return (p.x <= mousePt.x && mousePt.x <= (p.x + sideLength + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + sideLength + 1));
	}
}