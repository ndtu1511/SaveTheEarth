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
    private int countGame = 0;
    public void run(Cannon cannon,Graphics graphics){
        if(this.frameCounter.run()){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(cannon.position);
            rocket.velocity.set(cannon.position.subtract(400,400).normalize().multiply(this.speedRocket));
            this.frameCounter.reset();
            this.countGame = this.countGame + 1;
            if (this.countGame%25==1){
                this.frameCounter.max -=1;
                this.speedRocket +=1;
            }
            if (this.frameCounter.max <=6||this.speedRocket>=21){
                this.frameCounter.max = 7;
                this.speedRocket = 20;
            }
        }
    }
}
