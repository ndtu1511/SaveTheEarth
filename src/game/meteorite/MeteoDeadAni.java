package game.meteorite;

import Renderer.AnimationRenderer;
import constants.Constant;
import core.GameObject;

public class MeteoDeadAni extends GameObject {
    private AnimationRenderer animationRenderer;
    public MeteoDeadAni() {
        this.animationRenderer = new AnimationRenderer(false,4,
                Constant.Meteorite.PATH_METEO_DEAD);
        this.renderer = this.animationRenderer;
    }

    @Override
    public void run() {
        super.run();
        this.animationRenderer.disable = false;
        if (this.animationRenderer.disable){
            this.renderer=null;
            this.isAlive=false;
        }
    }
}
