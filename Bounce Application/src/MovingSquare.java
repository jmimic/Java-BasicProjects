/*
 *	===============================================================================
 *  Coder: Jacky Shew
 *	MovingSquare.java : A shape that is a square.
 *	A square has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */
import java.awt.*;

public class MovingSquare extends MovingShape {

	/** constructor to create a rectangle with default values
	 */
	public MovingSquare() {
		super();
	}

	/** constructor to create a rectangle shape
	 */
	public MovingSquare(int x, int y, int w, int h, float pw,  int mw, int mh, Color bc, int pathType) {
		super(x ,y ,w ,h ,pw ,mw ,mh ,bc, pathType);
	}

	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public void draw(Graphics g) {
		int sideLength = (Math.min(width, height));
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(penWidth));
		g2d.setPaint(borderColor);
		g2d.drawRect(p.x, p.y, sideLength, sideLength);
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + sideLength -2, p.y + sideLength -2, 4, 4);
			g.fillRect(p.x -2, p.y + sideLength -2, 4, 4);
			g.fillRect(p.x + sideLength -2, p.y-2, 4, 4);
		}
	}

	/** Returns whether the point is in the Square or not
	 * @return true if and only if the point is in the Square, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		int sideLength = (Math.min(width, height));
		return (p.x <= mousePt.x && mousePt.x <= (p.x + sideLength + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + sideLength + 1));
	}
}