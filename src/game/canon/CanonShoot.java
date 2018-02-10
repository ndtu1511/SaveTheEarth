package game.canon;

import Input.MouseInput;
import core.FrameCounter;
import core.GameObjectManager;
import game.canon.bullet.Bullet;

import java.awt.*;

public class CanonShoot {
    private FrameCounter frameCounter;
    private int countGame = 0;
    private int speedBullet = 8;
    public CanonShoot() {
        frameCounter = new FrameCounter(20);
        this.countGame = countGame;
    }

    public void run(Cannon cannon){
        if(this.frameCounter.run()){
            Bullet bullet = GameObjectManager.instance.recycle(Bullet.class);
            bullet.position.set(cannon.position);
            bullet.velocity.set(cannon.position.subtract(400,400).normalize().multiply(this.speedBullet));
            this.countGame++;
            this.frameCounter.reset();
            if (this.countGame%20==1){
                this.frameCounter.max -=1;
                this.speedBullet +=1;
            }
            if (this.frameCounter.max<=6){
                this.frameCounter.max = 7;
            }
            if (this.speedBullet>= 16){
                this.speedBullet =15;
            }
        }

    }
}
