package game.canon;

import Input.MouseInput;
import core.FrameCounter;
import core.GameObjectManager;
import game.canon.bullet.Bullet;

import java.awt.*;

public class CanonShoot {
    private FrameCounter frameCounter;
    public CanonShoot() {
        frameCounter = new FrameCounter(20);
    }

    public void run(Cannon cannon){
        if(this.frameCounter.run()){
            Bullet bullet = GameObjectManager.instance.recycle(Bullet.class);
            bullet.position.set(cannon.position);
            bullet.velocity.set(cannon.position.subtract(400,400).normalize().multiply(8));
            MouseInput.instance.isPressed=false;
            this.frameCounter.reset();
        }

    }
}
