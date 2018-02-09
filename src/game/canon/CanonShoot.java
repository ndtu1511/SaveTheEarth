package game.canon;

import Input.MouseInput;
import core.FrameCounter;
import core.GameObjectManager;
import core.Vector2D;
import Input.MouseMotionInput;

import java.awt.*;

public class CanonShoot {
    private FrameCounter frameCounter = new FrameCounter(10);
    public void run(Cannon cannon,Graphics graphics){
        if(this.frameCounter.run()){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(cannon.position);
            rocket.velocity.set(cannon.position.subtract(400,400).normalize().multiply(12));
            this.frameCounter.reset();
        }

    }
}
