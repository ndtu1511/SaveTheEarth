package game.background;

import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;
import core.Vector2D;

public class Suction extends GameObject {
    public Suction() {
        this.position = new Vector2D(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
        this.renderer = new ImageRenderer(Constant.BackGround.PATHSUCTION);
    }
}
