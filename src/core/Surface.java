package core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(180, -50);
        g2d.rotate(Math.toRadians(45));
        g2d.fillRect(80, 80, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

