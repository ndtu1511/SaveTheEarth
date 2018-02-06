import core.GameObjectManager;
import constants.Constant;
import game.background.BackGround;
import game.canon.Canon;
import game.earth.Earth;
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
        this.setupMeteoriteBorn();
//        this.setupCannon();
        this.setupEarth();
    }
    private void setupBackBuffer(){
        this.backBuffered = new BufferedImage(Constant.Windows.WIDTH,Constant.Windows.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }
    private void setupBackGround(){
        GameObjectManager.instance.recycle(BackGround.class);
    }
    private void setupEarth(){
        GameObjectManager.instance.recycle(Earth.class);
    }
    private void setupMeteoriteBorn(){
        GameObjectManager.instance.recycle(MeteoriteBorn.class);

    }
//    private void setupCannon(){
//        GameObjectManager.instance.recycle(Canon.class);
//
//    }

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
