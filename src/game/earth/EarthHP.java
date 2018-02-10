package game.earth;

import core.GameObjectManager;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class EarthHP {
    public int health;
    public Vector<HP> vector = new Vector<>();
    public int highScore = 0;
    public Vector plus1;

    public EarthHP(int health) {
        this.health = health;
        for (int i = 0; i < health; i++) {
            HP hp = GameObjectManager.instance.recycle(HP.class);
            hp.position.set(40 * i + 20, 20);
            this.vector.add(hp);
        }
    }
    public EarthHP (){
        this.highScore = highScore;
    }

    public boolean run(){
//        if(this.health == 0) {
//            return  false;
//        } else {
//            this.health -= 1;
//            vector.elementAt(health).isAlive = false;
//            return true;
//        }
        this.health--;
        vector.elementAt(health).isAlive=false;
        if (this.health==0){
            return false;
        }
        return true;
    }
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
}
