package game.meteorite;

import Core.FrameCounter;
import Core.GameObject;
import Core.GameObjectManager;
import Core.Vector2D;

import java.util.Random;

public class MeteoriteBorn extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Integer count;

    public MeteoriteBorn() {
        this.frameCounter = new FrameCounter(10);
        this.random = new Random();
        this.count = 0;
    }
    public void run(){
        if(this.frameCounter.run()) {
            Meteorite meteorite = new Meteorite();
            meteorite.position.set(new Vector2D(random.nextInt(780)+10,0));
            meteorite.velocity.set(new Vector2D(random.nextInt(3)-1, random.nextInt(4) + 3));
            GameObjectManager.instance.add(meteorite);
            this.frameCounter.reset();
        }
    }
}
