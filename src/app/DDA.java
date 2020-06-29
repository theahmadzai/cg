package app;

import java.awt.*;

public class DDA implements Line {
	Graphics g;
	Point p;
	Point q;

	public DDA(Graphics g) {
		this.g = g;
	}

	public void setP(Point p) {
		this.p = p;
		g.setColor(Color.GREEN);
		g.fillRect((int) p.getX(), (int) p.getY(), 1, 1);
	}

	public void setQ(Point q) {
		this.q = q;
		g.setColor(Color.BLUE);
		g.fillRect((int) p.getX(), (int) p.getY(), 1, 1);
	}

	public void draw() {
		double dx = q.getX() - p.getX();
		double dy = q.getY() - p.getY();

		double length = Math.max(dx, dy);

		double xInc = dx / length;
		double yInc = dy / length;

		int x = (int) p.getX();
		int y = (int) p.getY();

		g.setColor(Color.BLACK);

		for (int i = 1; i <= length; ++i) {
			g.fillRect(x, y, 1, 1);
			x += xInc;
			y += yInc;
		}
	}

}
