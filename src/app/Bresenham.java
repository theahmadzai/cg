package app;

import java.awt.Point;
import java.awt.Graphics;

public class Bresenham implements Line {
    Graphics g;
    Point p;
    Point q;

    public Bresenham(Graphics g) {
        this.g = g;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public void setQ(Point q) {
        this.q = q;
    }

    public void draw() {
        int x, y;
        int dx, dy;
        int incx, incy;
        int balance;
        int x1 = (int) p.getX();
        int y1 = (int) p.getY();
        int x2 = (int) p.getX();
        int y2 = (int) p.getY();

        if (x2 >= x1) {
            dx = x2 - x1;
            incx = 1;
        } else {
            dx = x1 - x2;
            incx = -1;
        }

        if (y2 >= y1) {
            dy = y2 - y1;
            incy = 1;
        } else {
            dy = y1 - y2;
            incy = -1;
        }

        x = x1;
        y = y1;
        boolean flag = true;
        if (dx < dy) {
            dx = dx ^ dy;
            dy = dx ^ dy;
            dx = dx ^ dy;
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
            x2 = x2 ^ y2;
            y2 = x2 ^ y2;
            x2 = x2 ^ y2;
            incx = incx ^ incy;
            incy = incx ^ incy;
            incx = incx ^ incy;
            flag = false;
        }

        dy <<= 1;
        balance = dy - dx;
        dx <<= 1;

        while (x != x2) {
            g.fillRect(flag ? x : y, flag ? y : x, 1, 1);

            if (balance >= 0) {
                y += incy;
                balance -= dx;
            }
            balance += dy;
            x += incx;
        }

        g.fillRect(flag ? x : y, flag ? y : x, 1, 1);
    }
}
