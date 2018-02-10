package scene;

import core.GameObjectManager;
import game.CrossHair.CrossHair;
import game.background.BackGround;
import game.background.Open;
import javafx.scene.layout.Background;

public class GameOverviewScene implements Scene {
    @Override
    public void init() {
        setupBackground();
        setupPlayButton();
        GameObjectManager.instance.recycle(CrossHair.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupPlayButton() {
        GameObjectManager.instance.recycle(PlayButton.class);
    }
    private void setupBackground() {
        GameObjectManager.instance.recycle(Open.class);
    }
}
