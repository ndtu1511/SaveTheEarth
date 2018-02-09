package game.canon;

import Input.MouseInput;
import core.FrameCounter;
import core.GameObjectManager;
import core.Vector2D;
import Input.MouseMotionInput;

import java.awt.*;

public class CanonShoot {
    private FrameCounter frameCounter = new FrameCounter(20);
    public int speedRocket = 3;
    private int count = 0;
    public void run(Cannon cannon,Graphics graphics){
        if(this.frameCounter.run()){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(cannon.position);
            rocket.velocity.set(cannon.position.subtract(400,400).normalize().multiply(this.speedRocket));
            this.frameCounter.reset();
            this.count = this.count + 1;
            if (this.count%20==1){
                this.frameCounter.max -=1;
                this.speedRocket +=1;
            }
            if (this.frameCounter.max <=4||this.speedRocket>=21){
                this.frameCounter.max = 5;
                this.speedRocket = 20;
            }
        }
    }
}
