package game.canon;

import Input.MouseInput;
import core.GameObjectManager;
import core.Vector2D;
import Input.MouseMotionInput;

import java.awt.*;

public class CanonShoot {
    public void run(Cannon cannon,Graphics graphics){
        if(MouseInput.instance.isPressed){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(cannon.position);
            rocket.velocity.set(cannon.position.subtract(400,400).normalize().multiply(8));
            MouseInput.instance.isPressed=false;
        }

    }
}
