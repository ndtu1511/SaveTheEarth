import core.GameObjectManager;
import constants.Constant;
import game.CrossHair.CrossHair;
import game.background.BackGround;
import game.background.Suction;
import game.canon.Cannon;
import game.earth.Earth;
import game.earth.EarthHP;
import game.earth.Score;
import game.meteorite.MeteoriteBorn;
import scene.GameOverviewScene;
import scene.SceneManager;
//import game.meteorite_medium.MeteoriteMediumBorn;

import javax.sound.sampled.Clip;
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
    Clip clip;
    EarthHP earthHP;
    Score score;
    public GameCanvas(){
        this.setSize(Constant.Windows.WIDTH,Constant.Windows.HEIGHT);
        this.setVisible(true);
        random = new Random();
        this.setupBackBuffer();

        this.earthHP = new EarthHP();
        score = new Score();
        SceneManager.instance.changeScene(new GameOverviewScene());
//        this.setupsoundBackGround();
    }
    private void setupBackBuffer(){
        this.backBuffered = new BufferedImage(Constant.Windows.WIDTH,Constant.Windows.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

//    private void setupsoundBackGround() {
//        this.clip = AudioUtils.instance.loadSound("resources/sound/bgm/nhacnenn.wav");
//        this.clip.loop(-1);
//        this.clip.start();
//    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }
    public void renderAll(){
        this.graphics.drawImage(this.backGround,0,0,null);
        GameObjectManager.instance.renderAll(graphics);
        score.doDrawing(graphics);
        score.repaint();
        this.repaint();
    }
    public void runAll(){
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangeSceneIfNeeded();
    }
}
