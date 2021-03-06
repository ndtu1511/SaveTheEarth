package game.earth;

import core.GameObject;
import core.GameObjectManager;

import java.awt.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Score extends JPanel {
    public static int highScore = 0;
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


        g2d.drawString(String.valueOf(highScore), 720, 30);
    }
    public void doDrawing2(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setFont(new Font("NewellsHand", Font.ITALIC, 40));
        g2d.setColor(Color.white);

        g2d.drawString("HIGHSCORE :" +String.valueOf(highScore), 520, 30);
    }
}

