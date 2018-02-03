package game.background;

import Core.GameObject;
import Renderer.ImageRenderer;
import constants.Constant;

public class TheEarth extends GameObject {
    public TheEarth() {
        this.renderer = new ImageRenderer(Constant.TheEarth.PATH);
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
    }
}
