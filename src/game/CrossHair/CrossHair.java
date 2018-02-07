package game.CrossHair;

import Input.MouseMotionInput;
import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;

public class CrossHair extends GameObject {
    public CrossHair() {
        this.renderer = new ImageRenderer(Constant.CrossHair.PATH);
        this.position.set(400,100);
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
    }
}
