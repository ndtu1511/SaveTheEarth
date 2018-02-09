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
    private void playerKeeper() {
        if (this.position.x > 765) this.position.x = 765;
        if (this.position.x < 0) this.position.x = 0;
        if (this.position.y > 720) this.position.y = 720;
        if (this.position.y < -45) this.position.y = -45;
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
        this.playerKeeper();
    }
}
