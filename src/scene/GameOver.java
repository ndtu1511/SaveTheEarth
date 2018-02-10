package scene;

import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;
import core.Vector2D;

public class GameOver extends GameObject {
    public GameOver() {
        this.position = new Vector2D(400,100);
        this.renderer = new ImageRenderer("resources/game_over/game over.png");
    }
}
