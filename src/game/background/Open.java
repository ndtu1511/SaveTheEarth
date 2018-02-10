package game.background;

import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;
import core.Vector2D;

public class Open extends GameObject {
    public Open() {
        this.position = new Vector2D(400,400);
        this.renderer = new ImageRenderer("resources/openning/OPEN.png");
    }
}
