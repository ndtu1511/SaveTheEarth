package game.canon;

import Input.MouseInput;
import core.GameObjectManager;
import core.Vector2D;
import Input.MouseMotionInput;

import java.awt.*;

public class CanonShoot {
    public void run(Cannon cannon,Graphics graphics){
        if(MouseInput.instance.isPressed){
            Graphics2D g2d = (Graphics2D) graphics.create();
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(cannon.position);
            rocket.velocity.set(cannon.position.subtract(400,400).normalize().multiply(5));
            g2d.rotate(Math.toRadians(360-Cannon.angle),cannon.position.x,cannon.position.y);
            MouseInput.instance.isPressed=false;
//            GameObjectManager.instance.add(rocket);
        }

    }
}
