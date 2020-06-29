package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JPanel {
    private static final long serialVersionUID = 1L;

    Line b = new DDA(getGraphics());

    public App() {
        setBackground(new Color(255, 255, 255));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1:
                        b.setP(e.getPoint());
                        break;
                    case MouseEvent.BUTTON3:
                        b.setQ(e.getPoint());
                        repaint();
                        break;
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Circle c = new Circle(getGraphics());
        c.setCenter(new Point(200, 200));
        c.setRadius(100);
        c.draw();
    }

    public static void gui() {
        JFrame frame = new JFrame("Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.getContentPane().add(new App());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(App::gui);
    }
}
