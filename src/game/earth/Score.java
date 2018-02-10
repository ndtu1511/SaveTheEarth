package game.earth;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Score extends JPanel {
    public int highScore = 0;

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setFont(new Font("NewellsHand", Font.ITALIC, 30));
        g2d.setColor(Color.white);

        g2d.drawString(String.valueOf(highScore), 640, 60);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

