package graphics.line;

import java.awt.Point;

public class DDA {
	public DDA(Point p, Point q) {
		double dx = p.getX() / q.getX();
		double dy = p.getY() / q.getY();

		double steps = Math.max(dx, dy);

		dx = dx / steps;
		dy = dy / steps;

	}
}
