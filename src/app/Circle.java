package app;

import java.awt.*;

public class Circle {
    Graphics g;
    Point c;
    int r;

    public Circle(Graphics g) {
        System.out.println(g);
        this.g = g;
    }

    public void setCenter(Point c) {
        this.c = c;
    }

    public void setRadius(int r) {
        this.r = r;
    }

    public double checkPointBoundry(Point p) {
        return Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2) - Math.pow(r, 2);
    }

    private void octantRule(Point p) {
        int xc = (int) c.getX();
        int yc = (int) c.getY();
        int x = (int) p.getX();
        int y = (int) p.getY();

        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc + y, yc + x, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc - y, yc + x, 1, 1);
        g.fillRect(xc + x, yc - y, 1, 1);
        g.fillRect(xc + y, yc - x, 1, 1);
        g.fillRect(xc - x, yc - y, 1, 1);
        g.fillRect(xc - y, yc - x, 1, 1);
    }

    public void draw() {
        int x = 0;
        int y = r;

        int p = 1 - r;

        octantRule(new Point(x, y));

        while (x < y) {
            x++;
            if (p < 0) {
                p += 2 * x + 1;
            } else {
                y--;
                p += 2 * (x - y) + 1;
            }
            octantRule(new Point(x, y));
        }
    }
}
