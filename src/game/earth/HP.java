package game.earth;

import Renderer.ImageRenderer;
import core.GameObject;

public class HP extends GameObject {
    public HP(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/ui/heart.png");
    }
}
