package scene;

import core.GameObjectManager;
import game.background.BackGround;

public class ReplayScreen implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(BackGround.class);
        GameObjectManager.instance.recycle(ReplayButton.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

}
