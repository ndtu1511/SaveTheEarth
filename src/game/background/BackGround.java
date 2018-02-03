package game.background;

import Core.GameObject;
import Renderer.ImageRenderer;
import utils.Utils;

public class Background extends GameObject {
    public Background() {
        this.renderer = new ImageRenderer("resources/background/background.jpg");
    }
}
