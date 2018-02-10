package scene;

import core.GameObjectManager;
import game.CrossHair.CrossHair;
import game.background.BackGround;
import game.background.Suction;
import game.canon.Cannon;
import game.earth.Earth;
import game.meteorite.MeteoriteBorn;


import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {
    Clip clip;

    @Override
    public void init() {
        this.setupBackGround();
        this.setupMeteoriteBorn();
        this.setupCannon();
        this.setupEarth();
        this.setupCrossHair();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }

    private void setupBackGround(){
        GameObjectManager.instance.recycle(BackGround.class);
        GameObjectManager.instance.recycle(Suction.class);
//        GameObjectManager.instance.recycle(Score.class);
    }
    private void setupEarth(){
        GameObjectManager.instance.recycle(Earth.class);
    }
    private void setupMeteoriteBorn(){
        GameObjectManager.instance.recycle(MeteoriteBorn.class);
//        GameObjectManager.instance.recycle(MeteoriteMediumBorn.class);

    }
    private void setupCannon(){
        GameObjectManager.instance.recycle(Cannon.class);
    }
    private void setupCrossHair(){
        GameObjectManager.instance.recycle(CrossHair.class);
    }
}
