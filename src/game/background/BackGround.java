package game.background;

import Core.GameObject;
import Renderer.ImageRenderer;
import utils.Utils;

public class BackGround extends GameObject {
    public BackGround() {
        this.renderer = new ImageRenderer("resources/background/background.jpg");
    }
}
