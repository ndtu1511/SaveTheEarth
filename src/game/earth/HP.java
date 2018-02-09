package game.earth;

import Renderer.ImageRenderer;
import core.GameObject;

public class HP extends GameObject {
    public HP(){
        this.renderer = new ImageRenderer("resources/UI/heart.png");
    }
}
