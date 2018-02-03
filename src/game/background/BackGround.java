package game.background;

import Core.GameObject;
import Core.Vector2D;
import Renderer.ImageRenderer;
import utils.Utils;

public class BackGround extends GameObject {
    public BackGround() {
        this.position = new Vector2D(400,400);
        this.renderer = new ImageRenderer("resources/background/background.jpg");
    }
}
