import Core.GameObjectManager;
import constants.Constant;
import game.background.BackGround;
import game.background.TheEarth;
import game.meteorite.Meteorite;
import game.meteorite.MeteoriteBorn;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameCanvas extends JPanel{
    BufferedImage backGround;
    BufferedImage backBuffered;
    BufferedImage meteorite;
    Graphics graphics;
    Random random;
    public GameCanvas(){
        this.setSize(Constant.Windows.WIDTH,Constant.Windows.HEIGHT);
        this.setVisible(true);
        random = new Random();
        this.setupBackBuffer();
        this.setupBackGround();
        this.setupMeteorite();
    }
    private void setupBackBuffer(){
        this.backBuffered = new BufferedImage(Constant.Windows.WIDTH,Constant.Windows.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }
    private void setupBackGround(){
        GameObjectManager.instance.recycle(BackGround.class);
        GameObjectManager.instance.recycle(TheEarth.class);
    }
    private void setupMeteorite(){
        GameObjectManager.instance.recycle(MeteoriteBorn.class);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }
    public void renderAll(){
        this.graphics.drawImage(this.backGround,0,0,null);
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }
    public void runAll(){
        GameObjectManager.instance.runAll();
//        ScenceManager.instance.performChangeSceneIfNeeded();
    }
}
