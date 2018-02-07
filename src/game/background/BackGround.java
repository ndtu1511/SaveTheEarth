package game.background;

import constants.Constant;
import core.GameObject;
import core.Vector2D;
import Renderer.ImageRenderer;

public class BackGround extends GameObject {
    public BackGround() {
        this.position = new Vector2D(400,400);
        this.renderer = new ImageRenderer(Constant.BackGround.PATH);
    }
}
