/*
 *	===============================================================================
 *  Coder: Jacky Shew
 *	MovingPolygon.java : A shape that is a MovingRotatingSquare
 *	A MovingRotatingSquare has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */

import java.awt.*;

public class MovingRotatingSquare extends MovingShape{
	
	/** constructor to create a Rotating Square with default values
	 */
	public MovingRotatingSquare() {
		super();
	}

	/** constructor to create a rectangle shape
	 */
	public MovingRotatingSquare(int x, int y, int w, int h, float pw,  int mw, int mh, Color bc, int pathType) {
		super(x ,y ,w ,h ,pw ,mw ,mh ,bc, pathType);
	}

	/** draw the Rotating Square with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public void draw(Graphics g) {
		int xPoint = p.x;
		int yPoint = p.y;
		int sideLength = (Math.min(width, height));
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(penWidth));
		g2d.setPaint(borderColor);
		Rectangle rect = new Rectangle(xPoint, yPoint, sideLength, sideLength);
		g2d.draw(rect);
		for (int i=0; i<100; i++){
			g2d.rotate(Math.toRadians(15),(xPoint+(sideLength/2)),(yPoint+(sideLength/2)));
			g2d.draw(rect);
		}
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + sideLength -2, p.y + sideLength -2, 4, 4);
			g.fillRect(p.x -2, p.y + sideLength -2, 4, 4);
			g.fillRect(p.x + sideLength -2, p.y-2, 4, 4);
		}
	}

	/** Returns whether the point is in the Rotating Square or not
	 * @return true if and only if the point is in the Rotating Square, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		int sideLength = (Math.min(width, height));
		return (p.x <= mousePt.x && mousePt.x <= (p.x + sideLength + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + sideLength + 1));
	}
}
