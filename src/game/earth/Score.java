package game.earth;

import core.GameObjectManager;

import java.awt.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Score extends JPanel {
    public int highScore = 0;
    public Vector plus1;

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
//        for (int i = 0, i <= ) {
//
//        }


        g2d.drawString(String.valueOf(highScore), 660, 30);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

