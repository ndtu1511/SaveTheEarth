package game.meteorite;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class MeteoriteBorn extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Integer count;

    public MeteoriteBorn() {
        this.frameCounter = new FrameCounter(20);
        this.random = new Random();
        this.count = 0;
    }
    public void run(){
        if(this.frameCounter.run()) {
            Meteorite meteorite = new Meteorite();
            int rd;
            rd = random.nextInt(3)+1;
            if (rd == 1) {
                meteorite.position.set(new Vector2D(5,random.nextInt(795)+5));
                meteorite.velocity.set(new Vector2D(random.nextInt(5), random.nextInt(9) - 4));
            } else if (rd == 2) {
                meteorite.position.set(new Vector2D(795,random.nextInt(795)+5));
                meteorite.velocity.set(new Vector2D(-random.nextInt(9)+4, random.nextInt(9) - 4));
            } else if (rd == 3) {
                meteorite.position.set(new Vector2D(random.nextInt(795)+5,5));
                meteorite.velocity.set(new Vector2D(random.nextInt(9)-4, random.nextInt(5)));
            } else if (rd == 4) {
                meteorite.position.set(new Vector2D(random.nextInt(795)+5,795));
                meteorite.velocity.set(new Vector2D(random.nextInt(9)-4, -random.nextInt(9) + 4));
            }
            GameObjectManager.instance.add(meteorite);
            this.frameCounter.reset();
        }
    }
}
