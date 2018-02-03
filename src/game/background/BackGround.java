package game.background;

import Core.GameObject;
import Renderer.ImageRenderer;
import constants.Constant;
import utils.Utils;

public class BackGround extends GameObject {
    public BackGround() {
        this.renderer = new ImageRenderer("resources/background/background.jpg");
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
    }
}
