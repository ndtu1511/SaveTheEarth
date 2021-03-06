package scene;

import core.GameObjectManager;
import game.CrossHair.CrossHair;
import game.background.BackGround;
import game.background.Open;
import game.earth.Score;

import java.awt.*;

public class ReplayScreen implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.recycle(BackGround.class);
        GameObjectManager.instance.recycle(ReplayButton.class);
        GameObjectManager.instance.recycle(CrossHair.class);
//        GameObjectManager.instance.recycle(GameOver.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        Score.highScore = 0;
    }

}
